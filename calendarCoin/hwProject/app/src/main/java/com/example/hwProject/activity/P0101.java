package com.example.hwProject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hwProject.R;

import org.json.JSONException;
import org.json.JSONObject;

/*
P0101 일정 등록, 수정페이지
여러 컴포넌트 등을 사용하여 일정을 등록하고 수정한다.
 */

public class P0101 extends AppCompatActivity {

    String stingTextInputPlan= null;   //계획의 제목 선언

    String stringTimeStartHour = null; //선택한 시작 시간
    String stringTimeStartMin = null; //선택한 시간 분

    String stringTimeEndHour = null; //선택한 종료 시간
    String stringTimeEndtMin = null; //선택한 종료 분

    String stringCb1 = null; //반복 월
    String stringCb2 = null; //반복 화
    String stringCb3 = null; //반복 수
    String stringCb4 = null; //반복 목
    String stringCb5 = null; //반복 금
    String stringCb6 = null; //반복 토
    String stringCb7 = null; //반복 일






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0101);


        //레이어 첫번째 : 계획 제목 적기
        final EditText textInputPlan = (EditText) findViewById(R.id.inputPlan); //사용자가 입력한 계획의 제목
        String stingTextInputPlan = textInputPlan.getText().toString(); //사용자가 입력한 계획의 제목 string 형태로 받음



        //레이어 두번째 : 시간 설정하기
        //Spinner로 받은 값 바인딩 시키기

        Spinner timeStartHour = (Spinner)findViewById(R.id.spinnerTimeStartHour);
        String  stringTimeStartHour = timeStartHour.getSelectedItem().toString();

        Spinner timeStartMin = (Spinner)findViewById(R.id.spinnerTimeStartMin);
        String  stringTimeStartMin = timeStartMin.getSelectedItem().toString();

        Spinner timeEndHour = (Spinner)findViewById(R.id.spinnerTimeEndHour);
        String  stringTimeEndHour = timeEndHour.getSelectedItem().toString();

        Spinner timeEndMin = (Spinner)findViewById(R.id.spinnerTimeEndMin);
        String  stringTimeEndMin = timeEndMin.getSelectedItem().toString();




        /* TODO : 구현 실패한 곳 -> 나중에 지우기
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


        //레이어 세번째 : 요일별 반복 설정하기

        CheckBox cb1 = (CheckBox)findViewById(R.id.checkBoxMon);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBoxTue);
        CheckBox cb3 = (CheckBox)findViewById(R.id.checkBoxWed);
        CheckBox cb4 = (CheckBox)findViewById(R.id.checkBoxThu);
        CheckBox cb5 = (CheckBox)findViewById(R.id.checkBoxFri);
        CheckBox cb6 = (CheckBox)findViewById(R.id.checkBoxSat);
        CheckBox cb7 = (CheckBox)findViewById(R.id.checkBoxSun);

        if(cb1.isChecked() == true) stringCb1 = cb1.getText().toString();
        if(cb2.isChecked() == true) stringCb2 = cb2.getText().toString();
        if(cb3.isChecked() == true) stringCb3 = cb3.getText().toString();
        if(cb4.isChecked() == true) stringCb4 = cb4.getText().toString();
        if(cb5.isChecked() == true) stringCb5 = cb5.getText().toString();
        if(cb6.isChecked() == true) stringCb6 = cb6.getText().toString();
        if(cb7.isChecked() == true) stringCb7 = cb7.getText().toString();




        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //TODO : saveButton의 기능을 구현한다.
                //textInputPlan
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("title", textInputPlan.getText().toString());
                    jsonObject.put("toDate", "test");
                    jsonObject.put("fromDate", "test");
                    jsonObject.put("toTime", "test");
                    jsonObject.put("fromTime", "test");
                    jsonObject.put("alarm", "test");
                    jsonObject.put("priority", "test");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println(jsonObject);
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
