package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Hp_PagerAdapter extends FragmentPagerAdapter {

    Fragment[] pages= new Fragment[3];
    String[] titles= new String[]{"퍼플추천","베스트","금주혜택"};


    public Hp_PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        pages[0]= new Hp01_purplerecommendation();
        pages[1]= new Hp02_best();
        pages[2]= new Hp03_week();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages[position];
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
