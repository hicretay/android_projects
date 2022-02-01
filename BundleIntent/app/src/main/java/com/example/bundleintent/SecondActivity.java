package com.example.bundleintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView txtNumber;
    Button btnAra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        txtNumber=findViewById(R.id.txtNumber);
        btnAra=findViewById(R.id.btnAra);

        Bundle datas=getIntent().getExtras();
        txtNumber.setText(datas.getString("no"));

        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNumber.getText().toString().equals(""))
                {
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel: "+txtNumber.getText().toString()));
                    startActivity(intent);
                }

            }
        });

    }
}
