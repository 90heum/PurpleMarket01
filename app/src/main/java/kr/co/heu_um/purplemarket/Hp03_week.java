package kr.co.heu_um.purplemarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Hp03_week extends Fragment {

    ArrayList<Home_Recycler03_item> items= new ArrayList<Home_Recycler03_item>();
    RecyclerView recyclerView;
    Home_Recycler03_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page03_week,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items.add(new Home_Recycler03_item(R.drawable.hera_02));
        items.add(new Home_Recycler03_item(R.drawable.hera_04));
        items.add(new Home_Recycler03_item(R.drawable.hera_05));
        items.add(new Home_Recycler03_item(R.drawable.hera_01));
        items.add(new Home_Recycler03_item(R.drawable.hera_02));
        items.add(new Home_Recycler03_item(R.drawable.hera_04));
        items.add(new Home_Recycler03_item(R.drawable.hera_05));
        items.add(new Home_Recycler03_item(R.drawable.hera_01));
        items.add(new Home_Recycler03_item(R.drawable.hera_02));
        items.add(new Home_Recycler03_item(R.drawable.hera_04));
        items.add(new Home_Recycler03_item(R.drawable.hera_05));
        items.add(new Home_Recycler03_item(R.drawable.hera_01));





        recyclerView= view.findViewById(R.id.recycler03);
        adapter=new Home_Recycler03_Adapter(getContext(),items);
        recyclerView.setAdapter(adapter);

    }
}
