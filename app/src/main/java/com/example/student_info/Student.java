package com.example.student_info;

public class Student {

    private  String name;
    private String age;
    private  String dep;
    private String cgpa;

    public Student(){

    }

    public Student(String name, String age, String dep, String cgpa) {
        this.name = name;
        this.age = age;
        this.dep = dep;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
}
