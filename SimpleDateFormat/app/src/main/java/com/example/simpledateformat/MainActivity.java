package com.example.simpledateformat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnDialog;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog=findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        //zaman değişikliği yapıldığında timePickerDialogun görünümü
//                        Date date=null;
//                        DateFormat frmt=new SimpleDateFormat("HH:mm");
//                        try {
//                            date=frmt.parse(hourOfDay+":"+minute);
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//                        Toast.makeText(context, frmt.format(date), Toast.LENGTH_SHORT).show();
//
//                    }
//                },13,0,true);
//                timePickerDialog.show();

                DatePickerDialog datePickerDialog=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(context, dayOfMonth+"/"+(month+1)+"/"+year, Toast.LENGTH_SHORT).show();

                    }
                },2017,5,13);
                datePickerDialog.setTitle("Alarm Saati");
                datePickerDialog.show();
            }
        });
    }
}