package com.example.student_info;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAd extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student>studentList;

    public CustomAd( Activity context, List<Student> studentList) {
        super(context, R.layout.activity_detail4, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.activity_detail4,null,true);

        Student student=studentList.get(position);
        TextView t1=view.findViewById(R.id.name_text);
        TextView t2=view.findViewById(R.id.age_view);
        TextView t3=view.findViewById(R.id.dep_TxId);
        TextView t4=view.findViewById(R.id.cg_Id);
        t1.setText("Name: "+student.getName());
        t2.setText("Age: "+student.getAge());
        t3.setText("dep: "+student.getDep());
        t4.setText("cgpa: "+student.getCgpa());

        return view;
    }
}
