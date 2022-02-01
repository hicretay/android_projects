package com.example.counter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Programatik extends AppCompatActivity {
    private LinearLayout pnl;
    private Button btnInrement;
    private TextView txtSayac;
    int sayac=0;
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(pnl);
    }

    public  void init()
    {
        pnl=new LinearLayout(context);
        pnl.setOrientation(LinearLayout.VERTICAL);

        txtSayac=new TextView(context);
        txtSayac.setText("Sayac : 0");
        txtSayac.setTextSize(25);

        btnInrement=new Button(context);
        btnInrement.setText("Arttir");
        btnInrement.setAllCaps(false); //kücük harfle yazması icin

        pnl.addView(txtSayac);
        pnl.addView(btnInrement);

        btnInrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++sayac;
                txtSayac.setText("Sayac : "+sayac);
            }
        });

    }
}
