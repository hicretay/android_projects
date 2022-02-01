package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{
    TextView text;
    SharedPreferenc sharedPreferenc;
    Context context=this;
    String donenDeger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        text=findViewById(R.id.text);
        sharedPreferenc=new SharedPreferenc();
        donenDeger=sharedPreferenc.getValue(context);
        text.setText(donenDeger);
    }
}
