package com.system.entity;

public class Selectedcourse {
    private Integer courseid;

    private Integer studentid;

    private Integer mark;

    private String studentname;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    @Override
    public String toString() {
        return "Selectedcourse{" +
                "courseid=" + courseid +
                ", studentid=" + studentid +
                ", mark=" + mark +
                ", studentname='" + studentname + '\'' +
                '}';
    }
}