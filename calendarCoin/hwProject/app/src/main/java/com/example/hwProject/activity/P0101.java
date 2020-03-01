package com.example.hwProject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hwProject.R;

/*
P0101 일정 등록, 수정페이지
여러 컴포넌트 등을 사용하여 일정을 등록하고 수정한다.
 */

public class P0101 extends AppCompatActivity {

    EditText textInputPlan = null;   //계획의 제목 선언
    int hourSelected; //선택한 시간
    int minSelected;  //선택한 분


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0101);

        //TODO : Spinner로 받은 값 바인딩 시키기

        /*


        //Spinner객체 생성
        final Spinner hourSpinner = (Spinner) findViewById(R.id.spinnerTimeStartHour);

        hourSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        //Spinner객체 생성
        final Spinner minSpinner = (Spinner) findViewById(R.id.spinnerTimeStartMin);

        minSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                minSelected = (int)parent.getSelectedItem();
            }
        });


         */


        textInputPlan = (EditText) findViewById(R.id.inputPlan); //사용자가 입력한 계획의 제목

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //TODO : saveButton의 기능을 구현한다.

            }

        });

        Button cancleButton = (Button) findViewById(R.id.cancelButton);
        cancleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void  onClick(View view){

                //TODO : cancleButton의 기능을 구현한다.
            }
        });
    }

}
