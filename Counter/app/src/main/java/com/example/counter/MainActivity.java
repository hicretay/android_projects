package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtSayac;
    Button arttir;
    Button azalt;
    int sayac=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSayac=findViewById(R.id.txtSayac);
        arttir=findViewById(R.id.btnArttir);
        azalt=findViewById(R.id.btnAzalt);

        arttir.setOnClickListener(this);
        azalt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnArttir:
                ++sayac;
                break;
            case R.id.btnAzalt:
                --sayac;
                break;
        }
        txtSayac.setText("Sayac : "+sayac);

    }

    //onClickListener ile tanımlama
//        arttir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ++sayac;
//                txtSayac.setText("Sayac : "+sayac);
//            }
//        });
//
//        azalt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                --sayac;
//                txtSayac.setText("Sayac: "+sayac);
//            }
//        });

    //ayni onClickte tanimlama
//    public  void btnIncrement_Click(View v) //tıklanan buton= v
//    {
//        switch (v.getId()){
//            case R.id.btnArttir :
//                ++sayac;
//                break;
//            case R.id.btnAzalt :
//                --sayac;
//                break;
//        }
//        txtSayac.setText("Sayac:"+sayac);
//    }

    //ayri ayri onClick verme
//    public  void btnDecrement_Click(View v)
//    {
//        --sayac;
//        txtSayac.setText("Sayac:"+sayac);
//    }

}