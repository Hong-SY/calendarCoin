package com.example.hwProject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwProject.R;
import com.example.hwProject.objects.AppCalendar;

import java.util.Date;

/**
 *
 */
public class CalendarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_YEAR = "year";
    private static final String ARG_MONTH = "month";

    // TODO: Rename and change types of parameters
    private int year;
    private int month;
    AppCalendar calendar;

    public CalendarFragment() {
        // Required empty public constructor
    }

    private CalendarFragment(int year, int month) {
        // TODO: 달력 계산해서 저장
        calendar = new AppCalendar(year, month);
    }

    public static CalendarFragment newInstance(int year, int month) {
        CalendarFragment fragment = new CalendarFragment(year, month);
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", month);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            year = getArguments().getInt(ARG_YEAR);
            month = getArguments().getInt(ARG_MONTH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_calendar,container, false);

        /** 2020.03.15 최홍재
         * 화면에 달력 띄우기
         * TODO : 석윤이가 만든 달력을 string 형태로 받아온다.
         */
        TextView textView = (TextView)rootView.findViewById(R.id.calendarTextView);
        //textView.setText(TODO);

        return rootView;



    }




}
