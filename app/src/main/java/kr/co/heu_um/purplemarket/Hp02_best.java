package kr.co.heu_um.purplemarket;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Hp02_best extends Fragment {
    ArrayList<Home_Recycler01_item> items= new ArrayList<Home_Recycler01_item>();
    RecyclerView recyclerView;
    Home_Recycler01_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page02_best,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      /*  items.add(new Home_Recycler01_item(R.drawable.ic_launcher_background,"김치","11500"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"양상추","1000"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"돼지고기","51500"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"미역","22500"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"김치","11500"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"양상추","1000"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"돼지고기","51500"));
        items.add(new Home_Recycler01_item(R.drawable.kurlymarket,"미역","22500"));*/



        recyclerView= view.findViewById(R.id.recycler02);
        adapter=new Home_Recycler01_Adapter(getContext(),items);
        recyclerView.setAdapter(adapter);

        //동적 퍼미션 살짝 다른방법으로 해보기
        String[] permissions= new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(ActivityCompat.checkSelfPermission(getContext(),permissions[0])== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(),permissions,100);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void loadData(){
        Retrofit retrofit=RetrofitHelper.getRetrofitInstanceGson();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ArrayList<Home_Recycler01_item>> call= retrofitService.loadDataFromServer();
        call.enqueue(new Callback<ArrayList<Home_Recycler01_item>>() {
            @Override
            public void onResponse(Call<ArrayList<Home_Recycler01_item>> call, Response<ArrayList<Home_Recycler01_item>> response) {
                //기존데이터들 모두제거
                items.clear();
                adapter.notifyDataSetChanged(); //무조건해줘야되는 코드!

                //결과로 받아온 Arraylist item 을 items에 추가!
                ArrayList<Home_Recycler01_item> list= response.body();
                for(Home_Recycler01_item item: list){
                    items.add(0,item);
                    adapter.notifyItemInserted(0);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Home_Recycler01_item>> call, Throwable t) {
                Toast.makeText(getContext(), "error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
