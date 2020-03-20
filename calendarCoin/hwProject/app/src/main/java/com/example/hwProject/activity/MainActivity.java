package com.example.hwProject.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hwProject.Adapter.MyPagerAdapter;
import com.example.hwProject.R;
import com.example.hwProject.module.DbOpenHelper;
import com.example.hwProject.objects.Schedule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/*

이곳은 메인 화면 입니다. (실제 보여지는 화면이 아닙니다.)
viewPager를 통환 화면 슬라이드에 관여하는 페이지 입니다.

 */

public class MainActivity extends AppCompatActivity {

    private MyPagerAdapter adapterViewPager;
    private  ViewPager viewPager;
    private DbOpenHelper mDbOpenHelper;
    /**
     * 2020.03.03 홍석윤
     */
    ArrayList<Schedule> scheduleList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** 2020.03.15 최홍재
         * Adapter package에 선언한 MyPagerAdapter.java
         */

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
//        mDbOpenHelper = new DbOpenHelper(this);
//        mDbOpenHelper.open();
//        mDbOpenHelper.create();
//        String title = "sfasflasknfklasnvkls";
//        String detail = "tksalngiasn";
//        String toDate = "";
//        String fromDate = "";
//        String alarm = "";
//        String priority = "";
//        String startHour = "";
//        String startMin = "";
//        String endHour = "";
//        String endMin = "";
//
//        mDbOpenHelper.insertColumn(title, detail, toDate, fromDate, alarm, priority, startHour, startMin, endHour, endMin);
//        showDatabase("title");
    }




    /**
     * 2020.3.03 홍석윤
     * json file을 읽어오는 함수
     */
    private String getJsonString(String jsonFileNm) {
        String json = "";
        try{
            InputStream is = getAssets().open(jsonFileNm);
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return json;
    }

    /**
     * 2020.03.03 홍석윤
     * json 문장을 파싱해 Schedule 객체에 저장해 scheduleList에 추가해준다.
     */
    private void jsonParsing(String json) {
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray scheduleArray = jsonObject.getJSONArray("schedules");

            for(int i=0 ; i<scheduleArray.length(); i++){
                JSONObject scheduleObject = scheduleArray.getJSONObject(i);

                Schedule schedule = new Schedule();
                schedule.setTitle(scheduleObject.getString("title"));
                schedule.setDetail(scheduleObject.getString("detail"));
                schedule.setToDate(scheduleObject.getString("toDate"));
                schedule.setFromDate(scheduleObject.getString("fromDate"));

                //홍재가 추가한 부분
                schedule.setFromDate(scheduleObject.getString("startHour"));
                schedule.setFromDate(scheduleObject.getString("startMin"));
                schedule.setFromDate(scheduleObject.getString("endHour"));
                schedule.setFromDate(scheduleObject.getString("endMin"));
                schedule.setFromDate(scheduleObject.getString("day"));
                //여기까지


                schedule.setAlarm(scheduleObject.getString("alarm"));
                schedule.setPriority(scheduleObject.getString("priority"));

                scheduleList.add(schedule);
            }

        }catch(JSONException ex){
            ex.printStackTrace();
        }
    }

    private void showDatabase(String sort){

        Cursor iCursor = mDbOpenHelper.sortColumn(sort);
        Log.d("showDatabase", "DB Size: " + iCursor.getCount());

        while(iCursor.moveToNext()){
            // String title, String detail, String toDate, String fromDate, String alarm, String priority, String startHour, String startMin
            String tempTitle = iCursor.getString(iCursor.getColumnIndex("title"));
            String tempDetail = iCursor.getString(iCursor.getColumnIndex("detail"));
            String tempToDate = iCursor.getString(iCursor.getColumnIndex("toDate"));
            String tempFromDate = iCursor.getString(iCursor.getColumnIndex("fromDate"));
            String tempAlarm = iCursor.getString(iCursor.getColumnIndex("alarm"));
            String tempPriority = iCursor.getString(iCursor.getColumnIndex("priority"));
            String tempStartHour = iCursor.getString(iCursor.getColumnIndex("startHour"));
            String tempStartMin = iCursor.getString(iCursor.getColumnIndex("startMin"));
            String tempEndHour = iCursor.getString(iCursor.getColumnIndex("endHour"));
            String tempEndMin = iCursor.getString(iCursor.getColumnIndex("endMin"));

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("title", tempTitle);
                jsonObject.put("detail", tempDetail);
                jsonObject.put("toDate", tempToDate);
                jsonObject.put("fromDate", tempFromDate);
                jsonObject.put("alarm", tempAlarm);
                jsonObject.put("priority", tempPriority);
                jsonObject.put("startHour", tempStartHour);
                jsonObject.put("startMin", tempStartMin);
                jsonObject.put("endHour", tempEndHour);
                jsonObject.put("endMin", tempEndMin);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(jsonObject.toString());

        }
    }
}
