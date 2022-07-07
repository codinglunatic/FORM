package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {

    TextView t5,t6,t7,t8,t9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent i = getIntent();
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);

        String name =i.getStringExtra("name");
        String age =i.getStringExtra("age");
        String dob =i.getStringExtra("dob");
        String email = i.getStringExtra("email");
        String gender=i.getStringExtra("sex");

        t5.setText(name);
        t6.setText(age);
        t7.setText(gender);
        t8.setText(dob);
        t9.setText(email);




    }
}