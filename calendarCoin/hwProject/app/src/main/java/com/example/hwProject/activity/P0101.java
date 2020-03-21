package com.example.hwProject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hwProject.R;
import com.example.hwProject.module.FileManage;
import com.example.hwProject.objects.Schedule;

import org.json.JSONException;
import org.json.JSONObject;

/*
P0101 일정 등록, 수정페이지
여러 컴포넌트 등을 사용하여 일정을 등록하고 수정한다.
 */

public class P0101 extends AppCompatActivity {

    Schedule schedule = new Schedule();
    FileManage fm = new FileManage();

    TextView textView; //이거 출력 실험용이므로 실험이 끝나면 지워줄꺼임

    String[] day = new String[7]; //반복할 요일
    CheckBox[] cbDay = new CheckBox[7]; //요일 체크박스 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0101);

        /** 2020.03.05 최홍재
         * TODO : 이제 xml에 입력한 값을 변수로 받아올 수 있으니 이걸 data에 넣어줘야함
        */

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                TextView textView = (TextView)findViewById(R.id.textView);

                //최홍재 레이어 첫번째 : 계획 제목 적기
                EditText textInputPlan = (EditText) findViewById(R.id.inputPlan); //사용자가 입력한 계획의 제목
                schedule.setTitle(textInputPlan.getText().toString());

                //최홍재 레이어 두번째 : 시간 설정하기
                Spinner timeStartHour = (Spinner)findViewById(R.id.spinnerTimeStartHour);
                schedule.setStartHour(timeStartHour.getSelectedItem().toString());

                Spinner timeStartMin = (Spinner)findViewById(R.id.spinnerTimeStartMin);
                schedule.setStartMin(timeStartMin.getSelectedItem().toString());

                Spinner timeEndHour = (Spinner)findViewById(R.id.spinnerTimeEndHour);
                schedule.setEndHour(timeEndHour.getSelectedItem().toString());

                Spinner timeEndMin = (Spinner)findViewById(R.id.spinnerTimeEndMin);
                schedule.setEndMin(timeEndMin.getSelectedItem().toString());

                //최홍재 레이더 세번째 : 반복 요일 설정하기
                cbDay[0] = (CheckBox)findViewById(R.id.checkBoxMon);
                cbDay[1] = (CheckBox)findViewById(R.id.checkBoxTue);
                cbDay[2] = (CheckBox)findViewById(R.id.checkBoxWed);
                cbDay[3] = (CheckBox)findViewById(R.id.checkBoxThu);
                cbDay[4] = (CheckBox)findViewById(R.id.checkBoxFri);
                cbDay[5] = (CheckBox)findViewById(R.id.checkBoxSat);
                cbDay[6] = (CheckBox)findViewById(R.id.checkBoxSun);

                for(int i=0 ; i<cbDay.length ; i++) { if(cbDay[i].isChecked() == true) day[i] = cbDay[i].getText().toString();}

                schedule.setDay(day);

                /** 2020.03.11 최홍재
                 * 레이어 네번째 : 무음, 진동, 소리 설정하기
                 */
                RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroupSound); //3가지 설정 중 하나만 체크하기 위한 그룹 설정
                RadioButton rb = (RadioButton)findViewById(rg1.getCheckedRadioButtonId()); //선택된 int형 id를 받아와서 라디오 버튼을 찾음
                schedule.setAlarm(rb.getText().toString());


                textView.setText(schedule.toString());


                String jsonstr = makeSchedule(schedule.getTitle(),"test","","","test","test", "test");

                boolean isFilePresent = fm.isFilePresent(getApplicationContext(), "storage.json");
                if(isFilePresent) {
                   String jsonString = fm.read(getApplicationContext(), "storage.json");
                   //do the json parsing here and do the rest of functionality of app
                } else {
                   boolean isFileCreated = fm.create(getApplicationContext(), "storage.json", jsonstr);
                   if(isFileCreated) {
                     //proceed with storing the first todo  or show ui
                   } else {
                     //show error or try again.
                   }
                }
                System.out.println(fm.read(getApplicationContext(), "storage.json"));

            }

        });

        Button cancleButton = (Button) findViewById(R.id.cancelButton);
        cancleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void  onClick(View view) {

                //TODO : cancleButton의 기능을 구현한다.


            }
        });
    }

    private String makeSchedule(String title, String toDate, String fromDate, String toTime, String fromTime, String alarm, String priority){
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
        return jsonObject.toString();
    }



}