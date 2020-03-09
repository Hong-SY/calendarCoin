package com.example.hwProject.objects;

public class Calendar {
    int year; //년도
    int month; //1월 ~ 12월
    Date[] calendar =new Date[42];

    public Calendar() {
    }

    public Calendar(int year, int month) {
        this.year = year;
        this.month = month;

        /**
         * TODO: 연도와 월로 일 계산해서 달력만들기
         */
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date[] getCalendar() {
        return calendar;
    }
}
