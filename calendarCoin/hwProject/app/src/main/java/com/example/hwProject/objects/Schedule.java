package com.example.hwProject.objects;

/**
 * 2020.03.03 홍석윤
 */
public class Schedule {

    /**
     * 변수 갯수 변경시
     * MainActivity.java > private void jsonParsing(String json)
     * 함께 변경
     */
    private String title;
    private String detail;
    private String toDate;
    private String fromDate;
    private String alarm;
    private String priority;

    //홍재가 추가한 변수
    private String startHour; //선택한 시작 시간
    private String startMin; //선택한 시간 분

    private String endHour; //선택한 종료 시간
    private String endMin; //선택한 종료 분

    private String[] day = new String[7]; //반복할 요일

    public Schedule() {
    }

    /**TODO
     * 요일설정 넣기
     *
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    /** 오 이렇게 하면 초록색 글씨 나옴
     * 홍재가 추가한 부분
     */

    public String getStartHour() {return startHour; }

    public void setStartHour(String startHour) { this.startHour = startHour;}

    public String getStartMin() { return startMin; }

    public void setStartMin(String startMin) { this.startMin = startMin; }

    public String getEndHour() { return endHour; }

    public void setEndHour(String endHour) { this.endHour = endHour; }

    public String getEndMin() { return endMin; }

    public void setEndMin(String endMin) { this.endMin = endMin; }

    public String[] getDay() { return day; }

    public void setDay(String[] day) { this.day = day; }

    @Override
    public String toString() {
        return "Schedule{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", toDate='" + toDate + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", startHour='" + startHour + '\'' +
                ", startMin='" + startMin + '\'' +
                ", endHour='" + endHour + '\'' +
                ", endMin='" + endMin + '\'' +
                ", day[0]='" + day[0] +'\''+
                ", day[1]='" + day[1] +'\''+
                ", day[2]='" + day[2] +'\''+
                ", day[3]='" + day[3] +'\''+
                ", day[4]='" + day[4] +'\''+
                ", day[5]='" + day[5] +'\''+
                ", day[6]='" + day[6] +'\''+
                ", alarm='" + alarm + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}