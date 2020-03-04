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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwProject.R;
import com.example.hwProject.objects.Schedule;

/*
P0101 일정 등록, 수정페이지
여러 컴포넌트 등을 사용하여 일정을 등록하고 수정한다.
 */

public class P0101 extends AppCompatActivity {

    private static final String TAG = "MyTag";

    Schedule schedule = new Schedule();
    TextView textView;

    String title= "hello"; //계획의 제목 선언
    String startHour = "00"; //선택한 시작 시간
    String startMin = "00"; //선택한 시간 분
    String endHour = "00"; //선택한 종료 시간
    String endMin = "00"; //선택한 종료 분

    String[] day = new String[7]; //반복할 요일

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0101);


        //TODO : schedule로 받은 변수로 받기..???

        //레이어 첫번째 : 계획 제목 적기
        EditText textInputPlan = (EditText) findViewById(R.id.inputPlan); //사용자가 입력한 계획의 제목
        final String title = textInputPlan.getText().toString(); //사용자가 입력한 계획의 제목 string 형태로 받음
        //schedule.setTitle(title);



        //레이어 두번째 : 시간 설정하기
        Spinner timeStartHour = (Spinner)findViewById(R.id.spinnerTimeStartHour);
        final String  startHour = timeStartHour.getSelectedItem().toString();
        //schedule.setStartHour(startHour);

        Spinner timeStartMin = (Spinner)findViewById(R.id.spinnerTimeStartMin);
        final String  startMin = timeStartMin.getSelectedItem().toString();
        //schedule.setStartMin(startMin);

        Spinner timeEndHour = (Spinner)findViewById(R.id.spinnerTimeEndHour);
        final String  endHour = timeEndHour.getSelectedItem().toString();
        //schedule.setEndHour(endHour);

        Spinner timeEndMin = (Spinner)findViewById(R.id.spinnerTimeEndMin);
        final String  endMin = timeEndMin.getSelectedItem().toString();
        //schedule.setEndMin(endMin);


        //레이어 세번째 : 요일별 반복 설정하기
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
        //schedule.setDay(day);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO : saveButton의 기능을 구현한다.
                //TextView textView = (TextView)findViewById(R.id.textView);

                /* 실험용 기능 나중에 지우기
                textView.setText(schedule.toString());
                textView.setText(title);
                textView.setText(startHour);
                textView.setText(startMin);
                textView.setText((endHour));
                textView.setText((endMin));
                for(int i =0 ; i<day.length ;i++){ textView.setText(day[i]); }
                 */


                Toast toast = Toast.makeText(getApplicationContext(),
                        "제목은 = " + title + "\n"+
                                "시작시간은 = " + startHour + "시" + startMin + "분"+"\n"+
                                "종료시간은 = " + endHour + "시" + endMin + "분"+"\n"+
                                "요일반복은 = " + day,
                        Toast.LENGTH_LONG);   // Toast 를 이용하여 알림창을 띄운다

                toast.show();   // show(); 꼭 붙여줘야 실행이 된다

                Log.d(TAG, "제목은 = " + title + "\n"+
                        "시작시간은 = " + startHour + "시" + startMin + "분"+"\n"+
                        "종료시간은 = " + endHour + "시" + endMin + "분"+"\n"+
                        "요일반복은 = " + day);


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
