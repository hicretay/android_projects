package com.example.startactivityforresaultintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {
    TextView txtSonuc;
    Button btnSonucYolla;
    int toplam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        txtSonuc=findViewById(R.id.txtSonuc);
        btnSonucYolla=findViewById(R.id.btnSonucYolla);

        btnSonucYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tekrar sonucu maine gönderme
                Intent returnIntent=new Intent();
                returnIntent.putExtra("toplam",toplam);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

        //MainActivityden gelen değerleri alma;
        Intent intent=getIntent();
        int x=Integer.parseInt(intent.getStringExtra("x"));
        int y=Integer.parseInt(intent.getStringExtra("y"));
        toplam=x+y;
        txtSonuc.setText(x+"+"+y+"="+toplam);


    }
}
