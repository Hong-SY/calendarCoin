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

import org.json.JSONException;
import org.json.JSONObject;

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

    }//end of onCreate

    /**
     *  2020.3.15 최홍재
     *  달력 날짜를 넣어줄 Adapter 생성 (실패)
     *  2020.03.19 최홍재
     * 각 date cell 마다 들어갈 정보를 처리해주는 adapter
     */

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


}//end of class MainActivity
