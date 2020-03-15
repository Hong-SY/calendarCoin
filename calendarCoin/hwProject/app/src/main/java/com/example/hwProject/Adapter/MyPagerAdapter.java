package com.example.hwProject.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hwProject.fragment.CalendarFragment;
import com.example.hwProject.fragment.FirstFragment;
import com.example.hwProject.fragment.SecondFragment;
import com.example.hwProject.fragment.ThirdFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CalendarFragment.newInstance(2020, 3); //TODO : 최홍재 2020.03.15 여기 석윤이가 만들 달력 받아야함
            case 1:
                return SecondFragment.newInstance(1, "Page # 2");
            case 2:
                return ThirdFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}