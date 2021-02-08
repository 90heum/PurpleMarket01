package kr.co.heu_um.purplemarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Tab01_HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager pager;

    Hp_PagerAdapter hp_pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //xml뷰 들에대한 find
        tabLayout= view.findViewById(R.id.layout_tab);
        pager=view.findViewById(R.id.pager);
        hp_pagerAdapter=new Hp_PagerAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);//현재보여지는상태만 온리쥼 해라 이런듯
        pager.setAdapter(hp_pagerAdapter);

        //탭,페이져 연동
        tabLayout.setupWithViewPager(pager);
    }
}
