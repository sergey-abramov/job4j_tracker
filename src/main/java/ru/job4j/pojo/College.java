package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Петров Иван Николаевич");
        student.setGroup("Водные пути");
        student.setCreated(new Date());
        System.out.println(student.getName() + " group : "
                + student.getGroup() + " date : " + student.getCreated());
    }
}
