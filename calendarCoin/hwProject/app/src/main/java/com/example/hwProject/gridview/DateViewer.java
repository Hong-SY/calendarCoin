package com.example.hwProject.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.hwProject.R;
import com.example.hwProject.objects.AppCalendar;

/**
 * 2020.03.18 최홍재
 * 각 셀 (각 date) 마다의 화면의 기능
 */

public class DateViewer extends LinearLayout {

    TextView textDate;

    public DateViewer(Context context) {
        super(context);

        init(context);
    }

    public DateViewer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar_single_date,this,true);

        textDate = (TextView)findViewById(R.id.textDate);

    }

    /**
     *
     * @param appCalendar 석윤이의 걸작
     * 2020.03.18 최홍재
     * 그래서 아마 setItem 이거 필요한가? 일단 보류
     * 2020.03.19 최홍재
     * 여기서 날짜를 정해줄 수 있다.
     * 앞으로 추가되는 내용도 여기 적힐 것이다.
     */

    public void setItem(AppCalendar appCalendar, int i){
        textDate.setText(Integer.toString(appCalendar.getAppCalendarDay(i)));

    }
}