package com.example.hwProject.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hwProject.R;
import com.example.hwProject.activity.P0104;
import com.example.hwProject.activity.P0103;
import com.example.hwProject.activity.P0101;


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

                Button btnCheckAllPlan = (Button)view.findViewById(R.id.checkAllPlan); // checkAllPlan 버튼
                btnCheckAllPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), P0104.class);
                        startActivity(intent);
                    }
                });

            Button btnModifyPlan = (Button)view.findViewById(R.id.modifyPlan); // modifyPlan 버튼
            btnModifyPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), P0101.class);
                    startActivity(intent);
                }
            });

            Button btnCheckDailyPlan = (Button)view.findViewById(R.id.checkDailyPlan); // P0103 버튼
            btnCheckDailyPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), P0103.class);
                    startActivity(intent);
                }
            });

            return view;
        }
}
