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
    private String toTime;
    private String fromTime;
    private String alarm;
    private String priority;

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

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
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

    @Override
    public String toString() {
        return "Schedule{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", toDate='" + toDate + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toTime='" + toTime + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", alarm='" + alarm + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}