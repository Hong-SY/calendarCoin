package com.example.hwProject.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hwProject.Adapter.MyPagerAdapter;
import com.example.hwProject.R;
import com.example.hwProject.fragment.FirstFragment;
import com.example.hwProject.fragment.SecondFragment;
import com.example.hwProject.fragment.ThirdFragment;
import com.example.hwProject.gridview.DateViewer;
import com.example.hwProject.objects.AppCalendar;
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

    }//end of onCreate

    /**
     *  2020.3.15 최홍재
     *  달력 날짜를 넣어줄 Adapter 생성 (실패)
     *  2020.03.19 최홍재
     * 각 date cell 마다 들어갈 정보를 처리해주는 adapter
     */

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
}//end of class MainActivity
