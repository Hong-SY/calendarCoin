package com.example.hwProject.objects;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * 2020.03.13
 * 홍석윤
 * 6주 형식 달력을 저장하는 클래스
 * 생성자에 int year, int month 전달시 달력이 만들어진다
 * ArrayList<Integer> appCalendar의 getter를 지원한다
 * appCalendar를 인덱스로 접근하는 getAppCalendarDay 메소드를 지원한다
 * 생성자로만 초기화가 가능하며 setter는 지원하지 않는다
 */
public class AppCalendar {
    private int year; //년도
    private int month; //1월 ~ 12월
    private ArrayList<Integer> appCalendar = new ArrayList<>();

    private Calendar cal = Calendar.getInstance();
    private int prevMonthTailOffset = 0;
    private int nextMonthHeadOffset = 0;
    private int currentMonthMaxDate = 0;

    public AppCalendar() {
    }

    public AppCalendar(int year, int month) {
        this.year = year;
        this.month = month;

        this.cal.set(Calendar.YEAR, year);
        this.cal.set(Calendar.MONTH, month-1);
        makeMonthDate();

        printCalendar();
    }

    /**
     * for Debugging
     * 콘솔에 달력 출력
     */
    private void printCalendar(){
        String a = "\n" + this.cal.get(Calendar.YEAR) + "년" + (this.cal.get(Calendar.MONTH)+1) + "월\n";
        for(int i=0 ; i<this.appCalendar.size() ; i++) {
            if((i%7)==0)
                a+="\n";
            a+=(this.appCalendar.get(i).toString() + "\t");
        }
        System.out.println(a);
    }

    private void makeMonthDate(){
        this.appCalendar.clear();
        this.cal.set(Calendar.DATE, 1);

        this.currentMonthMaxDate = this.cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        this.prevMonthTailOffset = this.cal.get(Calendar.DAY_OF_WEEK)-1;
        makePrevMonthTail((Calendar)this.cal.clone());
        makeCurrentMonth();
        this.nextMonthHeadOffset = 6*7 - (this.prevMonthTailOffset+this.currentMonthMaxDate);
        makeNextMonthHead();
    }

    private void makePrevMonthTail(Calendar cal) {
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        int maxOffsetDate = maxDate - this.prevMonthTailOffset;

        for(int i=1 ; i<=this.prevMonthTailOffset ; i++){
            this.appCalendar.add(++maxOffsetDate);
        }
    }

    private void makeCurrentMonth(){
        for(int i=1 ; i<=this.cal.getActualMaximum(Calendar.DATE); i++){
            this.appCalendar.add(i);
        }
    }

    private void makeNextMonthHead(){
        int date = 1;
        for(int i=0 ; i<this.nextMonthHeadOffset; i++){
            this.appCalendar.add(date++);
        }
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public ArrayList<Integer> getAppCalendar() {
        return this.appCalendar;
    }

    public int getAppCalendarDay(int idx){
        return this.appCalendar.get(idx);
    }
}
