package com.example.hwProject.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hwProject.R;
import com.example.hwProject.objects.Schedule;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

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

                textView.setText(schedule.toString());

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
    private String read(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    private boolean create(Context context, String fileName, String jsonString){
        //String FILENAME = "storage.json";
        try {
            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            if (jsonString != null) {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }

    }

    public boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }
    /* 실제 사용시 예시
    boolean isFilePresent = isFilePresent(getActivity(), "storage.json");
    if(isFilePresent) {
       String jsonString = read(getActivity(), "storage.json");
       //do the json parsing here and do the rest of functionality of app
    } else {
       boolean isFileCreated = create(getActivity, "storage.json", "{}");
       if(isFileCreated) {
         //proceed with storing the first todo  or show ui
       } else {
         //show error or try again.
       }
    }
     */
}


