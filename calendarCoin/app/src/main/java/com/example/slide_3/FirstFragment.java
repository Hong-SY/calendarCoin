package com.example.slide_3;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){

        // 2월20일 fragment에서 버튼을 가져올 때는 위와 같은 문법 사용

            View view = inflater.inflate(R.layout.fragment_first, container, false);

            Button btn_checkAllPlan = (Button)view.findViewById(R.id.checkAllPlan); // checkAllPlan 버튼
            btn_checkAllPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),CheckAllPlan.class);
                    startActivity(intent);
                }
            });

            Button btn_modifyPlan = (Button)view.findViewById(R.id.modifyPlan); // modifyPlan 버튼
            btn_modifyPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),ModifyPlan.class);
                    startActivity(intent);
                }
            });

            Button btn_checkDailyPlan = (Button)view.findViewById(R.id.checkDailyPlan); // CheckDailyPlan 버튼
            btn_checkDailyPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),CheckDailyPlan.class);
                    startActivity(intent);
                }
            });

            return view;
        }
}
