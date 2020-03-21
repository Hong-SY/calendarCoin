package com.example.hwProject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwProject.Adapter.DateAdapter;
import com.example.hwProject.R;
import com.example.hwProject.activity.MainActivity;
import com.example.hwProject.activity.P0101;
import com.example.hwProject.objects.AppCalendar;

import java.util.Date;


public class CalendarFragment extends Fragment {

    /**
     * 2020.03.18 최홍재
     * 달력 날짜 컴포넌트 선언
     */

    /** 홍재의 보류

    int[]  gridIdArray = {R.id.gridView00 , R.id.gridView01, R.id.gridView02 , R.id.gridView03, R.id.gridView04 , R.id.gridView05, R.id.gridView06,
                          R.id.gridView10 , R.id.gridView11, R.id.gridView12 , R.id.gridView13, R.id.gridView14 , R.id.gridView15, R.id.gridView16,
                          R.id.gridView20 , R.id.gridView21, R.id.gridView22 , R.id.gridView23, R.id.gridView24 , R.id.gridView25, R.id.gridView26,
                          R.id.gridView30 , R.id.gridView31, R.id.gridView32 , R.id.gridView33, R.id.gridView34 , R.id.gridView35, R.id.gridView36,
                          R.id.gridView40 , R.id.gridView41, R.id.gridView42 , R.id.gridView43, R.id.gridView44 , R.id.gridView45, R.id.gridView46,
                          R.id.gridView50 , R.id.gridView51, R.id.gridView52 , R.id.gridView53, R.id.gridView54 , R.id.gridView55, R.id.gridView56};

     */
    /**
     * 2020.03.19 최홍재
     * gridView 사용하기
     */

    GridView gridView;
    TextView dateText , monthText , yearText, testText;
    DateAdapter dateAdapter;

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
                R.layout.calendar_single_date_main, container, false);


        /**
         * 2020.03.18 최홍재
         * 화면에 달력 띄우기
         */

        /** 홍재의 보류

        TextView[] dateArray = new TextView[42];

        TextView textView =(TextView)rootView.findViewById(R.id.testTextView);

        // 기본 코드 TextView textDate = (TextView)rootView.findViewById(R.id.gridView00);
        for (int i = 0; i < gridIdArray.length; i++){
            dateArray[i] = (TextView)rootView.findViewById(gridIdArray[i]);
            dateArray[i].setText(Integer.toString(calendar.getAppCalendarDay(i)));
        }

         */

        /**
         * 2020.03.19 최홍재
         * gridView 사용하기
         */

        monthText = (TextView)rootView.findViewById(R.id.textMonth);
        monthText.setText(Integer.toString(calendar.getMonth()));

        yearText = (TextView)rootView.findViewById(R.id.textYear);
        yearText.setText(Integer.toString(calendar.getYear()));

        testText=(TextView)rootView.findViewById((R.id.testTextView));



        gridView = (GridView)rootView.findViewById(R.id.gridView);
        dateText = (TextView)rootView.findViewById(R.id.textDate);


        dateAdapter = new DateAdapter(getContext());
        for(int i =0 ; i<calendar.getAppCalendar().size() ; i++){
            dateAdapter.addItem(calendar);  // 2020.03.19 최홍재 한 날짜는 calendar 배열인 객체가 된다.
        }


        /**
         * 2020/03.19 최홍재
         * TODO : 지금은 그냥 수정페이지가 나오는데 여기는 날짜에 맞춘 각각의 수정페이지가 나와야한다.
         * TODO : 눌렀을 때 다른 기능들 생각해봅시다~
         */

        gridView.setAdapter(dateAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /**
                 * 2019.03.19 최홍재(보류)
                 *
                 * Intent intent = new Intent(getActivity(), P0101.class);
                 *                         startActivity(intent);
                 */

                Toast.makeText(getActivity(),"번호 : "+ Integer.toString(dateAdapter.getItem(i).getAppCalendarDay(i)),Toast.LENGTH_LONG).show();


                    }
                });
        return rootView;
    }
}

