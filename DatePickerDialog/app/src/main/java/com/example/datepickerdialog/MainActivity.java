package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDateDialog;
    TextView txtDate;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDateDialog=findViewById(R.id.btnDateDialog);
        txtDate=findViewById(R.id.txtDate);

        btnDateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar simdikiZaman=Calendar.getInstance();
                int yil=simdikiZaman.get(Calendar.YEAR); //mevcut yılı alır
                int ay=simdikiZaman.get(Calendar.MONTH);
                int gun=simdikiZaman.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },yil,ay,gun);  //baslangıcta set edilecek degerler
                datePickerDialog.setTitle("Tarih seçiniz: ");
                datePickerDialog.show();
            }
        });
    }
}