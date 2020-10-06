package com.example.student_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class detailActivity extends AppCompatActivity {

    private ListView listView;
    private List<Student> studentList;
    private CustomAd customAd;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        databaseReference= FirebaseDatabase.getInstance().getReference("student");

        studentList=new ArrayList<>();
        customAd=new CustomAd(detailActivity.this,studentList);
        listView=(ListView)findViewById(R.id.list_id);
    }

    @Override
    protected void onStart() {

         databaseReference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 studentList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Student student=dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }

                listView.setAdapter(customAd);

             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });
        super.onStart();
    }
}
