package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTime;
    TextView txtTime;
    TimePicker tpSonuc;
    StringBuilder sonuc;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime=findViewById(R.id.btnTime);
        txtTime=findViewById(R.id.txtTime);
        tpSonuc=findViewById(R.id.tpSonuc);
        sonuc=new StringBuilder();

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar simdikiZaman=Calendar.getInstance();
                int saat=simdikiZaman.get(Calendar.HOUR);
                int dakika=simdikiZaman.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //dialogdan yapılan seçimin textView a basılması
                        txtTime.setText(hourOfDay+":"+minute);

                    }
                },saat,dakika,true);
                timePickerDialog.setTitle("Saat Seçiniz");
                timePickerDialog.show();

            }
        });
//        btnTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar simdikiZaman=Calendar.getInstance();
//                int saat=simdikiZaman.get(Calendar.HOUR);
//                int dakika=simdikiZaman.get(Calendar.MINUTE);
//                sonuc.delete(0,sonuc.length());
//                sonuc.append(saat).append(":").append(dakika);
//                txtTime.setText(sonuc);
//
//                //mevcut tarihi basma
//                tpSonuc.setCurrentHour(saat);
//                tpSonuc.setCurrentMinute(dakika);
//            }
//        });

        tpSonuc.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                sonuc.delete(0,sonuc.length());
                sonuc.append(hourOfDay).append(":").append(minute);
                txtTime.setText(sonuc);

            }
        });

    }

}