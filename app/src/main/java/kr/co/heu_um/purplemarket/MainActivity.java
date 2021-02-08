package kr.co.heu_um.purplemarket;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    Fragment[] fragments= new Fragment[5];
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        //Home 기본화면설정
        FragmentTransaction tran=fragmentManager.beginTransaction();
        fragments[0]=new Tab01_HomeFragment();
        tran.add(R.id.container,fragments[0]);
        tran.commit();

        bnv=findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //hide 방식

                FragmentTransaction tran= fragmentManager.beginTransaction();
                if(fragments[0]!=null) tran.hide(fragments[0]);
                if(fragments[1]!=null) tran.hide(fragments[1]);
                if(fragments[2]!=null) tran.hide(fragments[2]);
                if(fragments[3]!=null) tran.hide(fragments[3]);
                if(fragments[4]!=null) tran.hide(fragments[4]);

                switch (item.getItemId()){

                    case  R.id.bnv_home:
                        tran.show(fragments[0]);
                        break;

                    case  R.id.bnv_recommendation:
                        if(fragments[1]==null){
                            fragments[1]= new Tab02_RecommendationFragment();
                            tran.add(R.id.container,fragments[1]);
                        }
                        tran.show(fragments[1]);
                        break;

                    case  R.id.bnv_category:
                        if(fragments[2]==null){
                            fragments[2]= new Tab03_CategoryFragment();
                            tran.add(R.id.container,fragments[2]);
                        }
                        tran.show(fragments[2]);
                        break;

                    case  R.id.bnv_search:
                        if(fragments[3]==null){
                            fragments[3]= new Tab04_SearchFragment();
                            tran.add(R.id.container,fragments[3]);
                        }
                        tran.show(fragments[3]);
                        break;

                    case  R.id.bnv_mypurple:
                        if(fragments[4]==null){
                            fragments[4]= new Tab05_MypurpleFragment();
                            tran.add(R.id.container,fragments[4]);
                        }
                        tran.show(fragments[4]);
                        break;

                }
                tran.commit();




                return true;
            }
        });



    }
}