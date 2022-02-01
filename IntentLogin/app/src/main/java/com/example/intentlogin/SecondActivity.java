package com.example.intentlogin;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{
    Button btnSiteyeGit,btnGeri;
    TextView txtGelenDeger;
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        btnSiteyeGit=findViewById(R.id.btnSiteyeGit);
        btnGeri=findViewById(R.id.btnGeri);
        txtGelenDeger=findViewById(R.id.txtGelenDeger);

        Intent intent=getIntent();
        txtGelenDeger.setText("Hosgeldin "+intent.getStringExtra("isim"));



        btnSiteyeGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://google.com.tr"));
                startActivity(intent);
            }
        });

        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
