package com.example.piyush.studentlistview;

import java.util.ArrayList;

/**
 * Created by Piyush on 6/25/2016.
 */
public class Students {

    public static class Student {
        final String name;
        final int age;
        final int photoID;

        public Student(String name, int age, int photoID){
            this.age = age;
            this.name = name;
            this.photoID = photoID;
        }
    }

    public static ArrayList<Student> getStudents(){
        ArrayList<Student> Students = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            Student stu = new Student("a" + i, i + 10, R.mipmap.ic_launcher);
            Students.add(stu);
        }
        return Students;
    }
}
