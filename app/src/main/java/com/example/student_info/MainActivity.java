package com.example.student_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button savedata,displaydata;
    private EditText nameIp,ageIp,depIp,cagpaIp;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference= FirebaseDatabase.getInstance().getReference("student");


        displaydata=(Button)findViewById(R.id.DISPLAY_id);
        savedata=(Button)findViewById(R.id.add_id);
        nameIp=(EditText)findViewById(R.id.name_Id);
        ageIp=(EditText)findViewById(R.id.age_id);
        depIp=(EditText)findViewById(R.id.dep_Id);
        cagpaIp=(EditText)findViewById(R.id.cgpa_Id);

        displaydata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,detailActivity.class);
                startActivity(intent);
            }
        });

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stroredata();

            }
        });
    }

    public void stroredata() {

        String name=nameIp.getText().toString().trim();
        String age=ageIp.getText().toString().trim();
        String dep=depIp.getText().toString().trim();
        String cgpa=cagpaIp.getText().toString().trim();

        String key=databaseReference.push().getKey();
        Student student=new Student(name,age,dep,cgpa);
        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"info added",Toast.LENGTH_LONG).show();




    }
}
