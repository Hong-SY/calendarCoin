package com.example.hwProject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.hwProject.fragment.FirstFragment;
import com.example.hwProject.R;
import com.example.hwProject.fragment.SecondFragment;
import com.example.hwProject.fragment.ThirdFragment;
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
    FragmentPagerAdapter adapterViewPager;

    /**
     * 2020.03.03 홍석윤
     */
    ArrayList<Schedule> scheduleList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return FirstFragment.newInstance(0, "Page # 1");
                case 1:
                    return SecondFragment.newInstance(1, "Page # 2");
                case 2:
                    return ThirdFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

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
                schedule.setToTime(scheduleObject.getString("toTime"));
                schedule.setFromTime(scheduleObject.getString("fromTime"));
                schedule.setAlarm(scheduleObject.getString("alarm"));
                schedule.setPriority(scheduleObject.getString("priority"));

                scheduleList.add(schedule);
            }

        }catch(JSONException ex){
            ex.printStackTrace();
        }
    }
}
