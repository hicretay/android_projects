package com.example.bundleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNumara;
    Button btnYolla;
    Bundle bundle;
    Intent intent;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumara=findViewById(R.id.etNumara);
        btnYolla=findViewById(R.id.btnYolla);


        btnYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(context,SecondActivity.class);
                bundle=new Bundle();
                bundle.putString("no",etNumara.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}




