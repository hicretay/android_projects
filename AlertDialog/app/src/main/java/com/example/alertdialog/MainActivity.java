package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnGoster;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoster=findViewById(R.id.btnGoster);
        btnGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
                alertDialog.setTitle("Alert Daiog")
                        .setMessage("Çıkılsın mı?")
                        .setCancelable(false) //diyalog pencersinin etrafına tıklanınca kapansın mı? demketir
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //evete tıklanınca olacaklar
                                finish(); //uygulamayı kapatır
                            }
                        })
                        .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //hayıra basınca olacaklar
                                dialog.dismiss(); //pencereyi kapatır
                            }
                        }).show();

            }
        });
    }
}