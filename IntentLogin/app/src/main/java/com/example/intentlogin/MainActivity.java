package com.example.intentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etPass;
    Button btnGonder,btnTemizle;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnGonder.setOnClickListener(this);
        btnTemizle.setOnClickListener(this); // implemente edilen metotlar bildirilir

    }
    public void init()
    {
        etName=findViewById(R.id.etName);
        etPass=findViewById(R.id.etPass);
        btnGonder=findViewById(R.id.btnGonder);
        btnTemizle=findViewById(R.id.btnTemizle);
    }

    @Override
    public void onClick(View v) {  //v tıklanan buton
        switch (v.getId())
        {
            case R.id.btnGonder:
                if(etName.getText().toString().equalsIgnoreCase("admin")&& etPass.getText().toString().equals("1234") )
                {
                    Intent intent=new Intent(context,SecondActivity.class);
                    intent.putExtra("isim",etName.getText().toString());
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(context, "Kullanıcı adı veya şifre hatalı", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnTemizle:
                etName.setText("");
                etPass.setText("");
                etName.requestFocus();
                break;
        }

    }
}