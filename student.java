package com.southwind.entity;

public class student{
    private int studentId;
    private String studentName;
    private String age;

    public student(int studentId, String studentName, String age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
