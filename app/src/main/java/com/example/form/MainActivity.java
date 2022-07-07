package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;



import java.util.Calendar;

import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;






public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText e1,e2,e3,e4;
    RadioButton r1,r2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i= new Intent(this,display.class);


        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);

        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);

        e1.setError("shouldnt be empty");

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked()){
                    r2.setChecked(false);
                }
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r2.isChecked()){
                    r1.setChecked(false);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   if (isValidEmail(String.valueOf(e3.getText()))) {

                       if (r1.isChecked()) i.putExtra("sex", "male");
                       else i.putExtra("sex", "female");

                       i.putExtra("name", String.valueOf(e1.getText()));
                       i.putExtra("age", String.valueOf(e2.getText()));
                       i.putExtra("dob", String.valueOf(e3.getText()));
                       i.putExtra("email", String.valueOf(e4.getText()));


                       startActivity(i);
                   }

                   else
                   {

                       CharSequence text = "invalid email";


                       Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                       toast.show();
                   }


            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Please note that use your package name here
                com.example.form.Datepicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.example.form.Datepicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");

            }
        });

    }

   @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
       // e3.setText(selectedDate);
       e3.setText(dayOfMonth+"/" + String.valueOf(month+1)+"/"+year);
    }

    public static boolean isValidEmail(String target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}


