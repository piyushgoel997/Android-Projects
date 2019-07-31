package com.example.piyush.studentfragment;

import java.util.ArrayList;

/**
 * Created by Piyush on 6/26/2016.
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
        ArrayList<Student> studentList = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            studentList.add(new Student("A" + i,i + 10,R.mipmap.ic_launcher));
        }
        return studentList;
    }

}
