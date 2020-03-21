package com.example.hwProject.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hwProject.fragment.CalendarFragment;
import com.example.hwProject.fragment.FirstFragment;
import com.example.hwProject.fragment.SecondFragment;
import com.example.hwProject.fragment.ThirdFragment;

import java.time.LocalDate;


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

    /**
     * 2020.03.19 최홍재
     * 이제 여기 한정된 수가 아니라 무한하도록 logic만들기
     * 현재날짜를 알고 그 fragment를 default로 하기
     */
    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return FirstFragment.newInstance(0,"0");
                case 1:
                    return CalendarFragment.newInstance(2020, 3);
                case 2:
                    return CalendarFragment.newInstance(2020, 4);
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