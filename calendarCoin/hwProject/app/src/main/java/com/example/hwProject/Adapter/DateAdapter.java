package com.example.hwProject.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hwProject.gridview.DateViewer;
import com.example.hwProject.objects.AppCalendar;

import java.util.ArrayList;

public class DateAdapter extends BaseAdapter {

    private Context mContext; // 2020.03.19 최홍재 이거 중요함 슈벌,,,, 없으면 안댐 1시부터 4시까지 해맴

    public DateAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<AppCalendar> items = new ArrayList<AppCalendar>();


    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(AppCalendar appCalendar) {
        items.add(appCalendar);
    }

    @Override
    public AppCalendar getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DateViewer dateViewer = new DateViewer(mContext);
        dateViewer.setItem(items.get(i),i); //2020 03 19 최홍재 이거 중요함. 각 셀의 아이템 배열 = AppCalendar의 day 배열과 같음
        return dateViewer;
    }
}
