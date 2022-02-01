package com.example.ikisayinintoplami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTopla,btnCikar,btnCarp,btnBol;
    EditText sayi1,sayi2;
    TextView txtSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       init();
       btnTopla.setOnClickListener(this);
       btnCikar.setOnClickListener(this);
       btnCarp.setOnClickListener(this);
       btnBol.setOnClickListener(this);


    }

    public  void init()
    {
        sayi1=findViewById(R.id.etSayiBir);
        sayi2=findViewById(R.id.etSayiİki);

        btnTopla=findViewById(R.id.btnTopla);
        btnCikar=findViewById(R.id.btnCikar);
        btnCarp=findViewById(R.id.btnCarp);
        btnBol=findViewById(R.id.btnBol);

        txtSonuc=findViewById(R.id.txtSonuc);

    }

    @Override
    public void onClick(View v) {
        int ilkDeger=Integer.parseInt(sayi1.getText().toString());
        int ikinciDeger=Integer.parseInt(sayi2.getText().toString());

        switch (v.getId())
        {
            case R.id.btnTopla:
                txtSonuc.setText(String.valueOf(ilkDeger+ikinciDeger));
                break;

            case R.id.btnCikar:
                txtSonuc.setText(String.valueOf(ilkDeger-ikinciDeger));
                break;

            case R.id.btnCarp:
                txtSonuc.setText(String.valueOf(ilkDeger*ikinciDeger));
                break;

            case R.id.btnBol:
                txtSonuc.setText(String.valueOf(ilkDeger/ikinciDeger));
                break;
        }
    }
}