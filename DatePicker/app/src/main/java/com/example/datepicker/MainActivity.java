package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTarihDegistir;
    TextView txtTarih;
    DatePicker dpSonuc;
    StringBuilder sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTarihDegistir=findViewById(R.id.btnTarihDegistir);
        txtTarih=findViewById(R.id.txtTarih);
        dpSonuc=findViewById(R.id.dpSonuc);
        sonuc=new StringBuilder();

        btnTarihDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar simdikiZaman=Calendar.getInstance();
                int yil=simdikiZaman.get(Calendar.YEAR);
                int ay=simdikiZaman.get(Calendar.MONTH);
                int gün=simdikiZaman.get(Calendar.DAY_OF_MONTH);
            }
        });

        //dpSonuc.updateDate(2017,05,13);  başlangıc degeri
        dpSonuc.init(2017, 5, 13, new DatePicker.OnDateChangedListener() {  //datepickerdaki tarih değiştiğinde olacak olaylar
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                sonuc.delete(0,sonuc.length());  //her seferinde textview i temizleme
                sonuc.append(year).append("-").append(monthOfYear+1).append("-").append(dayOfMonth);
                txtTarih.setText(sonuc);
            }
        });
    }
}