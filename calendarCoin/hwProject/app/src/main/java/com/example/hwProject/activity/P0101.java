package com.example.hwProject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
<<<<<<< HEAD
import android.widget.TextView;
import android.widget.Toast;
=======

import androidx.appcompat.app.AppCompatActivity;
>>>>>>> 8096109d110cba46191b7598a75bcac604d20440

import com.example.hwProject.R;
import com.example.hwProject.objects.Schedule;

import org.json.JSONException;
import org.json.JSONObject;

/*
P0101 일정 등록, 수정페이지
여러 컴포넌트 등을 사용하여 일정을 등록하고 수정한다.
 */

public class P0101 extends AppCompatActivity {

    Schedule schedule = new Schedule();

    TextView textView; //이거 출력 실험용이므로 실험이 끝나면 지워줄꺼임
    String[] day = new String[7]; //반복할 요일

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0101);

        /** 2020.03.05 최홍재
         * TODO : day 배열 받는것 성공해야함
         * TODO : 이제 xml에 입력한 값을 변수로 받아올 수 있으니 이걸 data에 넣어줘야함
        */

<<<<<<< HEAD
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
=======
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
>>>>>>> 8096109d110cba46191b7598a75bcac604d20440

            @Override
            public void onClick(View view) {

                TextView textView = (TextView)findViewById(R.id.textView);

                //레이어 첫번째 : 계획 제목 적기
                EditText textInputPlan = (EditText) findViewById(R.id.inputPlan); //사용자가 입력한 계획의 제목
                schedule.setTitle(textInputPlan.getText().toString());

                //레이어 두번째 : 시간 설정하기
                Spinner timeStartHour = (Spinner)findViewById(R.id.spinnerTimeStartHour);
                schedule.setStartHour(timeStartHour.getSelectedItem().toString());

                Spinner timeStartMin = (Spinner)findViewById(R.id.spinnerTimeStartMin);
                schedule.setStartMin(timeStartMin.getSelectedItem().toString());

                Spinner timeEndHour = (Spinner)findViewById(R.id.spinnerTimeEndHour);
                schedule.setEndHour(timeEndHour.getSelectedItem().toString());

                Spinner timeEndMin = (Spinner)findViewById(R.id.spinnerTimeEndMin);
                schedule.setEndMin(timeEndMin.getSelectedItem().toString());

                // TODO : (여기 아직 작동잘 안해서 손봐야함) 레이어 세번째 : 요일별 반복 설정하기
                CheckBox cb1 = (CheckBox)findViewById(R.id.checkBoxMon);
                CheckBox cb2 = (CheckBox)findViewById(R.id.checkBoxTue);
                CheckBox cb3 = (CheckBox)findViewById(R.id.checkBoxWed);
                CheckBox cb4 = (CheckBox)findViewById(R.id.checkBoxThu);
                CheckBox cb5 = (CheckBox)findViewById(R.id.checkBoxFri);
                CheckBox cb6 = (CheckBox)findViewById(R.id.checkBoxSat);
                CheckBox cb7 = (CheckBox)findViewById(R.id.checkBoxSun);

                if(cb1.isChecked() == true) day[0] = cb1.getText().toString();
                if(cb2.isChecked() == true) day[1] = cb2.getText().toString();
                if(cb3.isChecked() == true) day[2] = cb3.getText().toString();
                if(cb4.isChecked() == true) day[3] = cb4.getText().toString();
                if(cb5.isChecked() == true) day[4] = cb5.getText().toString();
                if(cb6.isChecked() == true) day[5] = cb6.getText().toString();
                if(cb7.isChecked() == true) day[6] = cb7.getText().toString();
                schedule.setDay(day);

<<<<<<< HEAD
                textView.setText(schedule.toString());
=======
            @Override
            public void onClick(View view) {

                //TODO : saveButton의 기능을 구현한다.
                //textInputPlan
>>>>>>> 8096109d110cba46191b7598a75bcac604d20440

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
<<<<<<< HEAD
=======

    private JSONObject makeSchedule(String title, String toDate, String fromDate, String toTime, String fromTime, String alarm, String priority){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", title);
            jsonObject.put("toDate", toDate);
            jsonObject.put("fromDate", fromDate);
            jsonObject.put("toTime", toTime);
            jsonObject.put("fromTime", fromTime);
            jsonObject.put("alarm", alarm);
            jsonObject.put("priority", priority);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
>>>>>>> 8096109d110cba46191b7598a75bcac604d20440
}
