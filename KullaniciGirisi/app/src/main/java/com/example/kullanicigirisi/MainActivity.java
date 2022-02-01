package com.example.kullanicigirisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button login, cancel;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.etKullanici);
        pass=findViewById(R.id.etSifre);
        login=findViewById(R.id.btnGonder);
        cancel=findViewById(R.id.btnTemizle);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equalsIgnoreCase("admin")&&pass.getText().toString().equals("1234"))
                {
                    Toast.makeText(context, "Giriş Başarılı ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(context, "Tekrar Deneyiniz", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setText("");
                pass.setText("");
            }
        });
    }
}