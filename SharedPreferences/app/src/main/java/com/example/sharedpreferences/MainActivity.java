package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSave,btnDelete,btnRemove,btnGo;
    EditText etIsım;
    CheckBox chk1;
    String text;
    SharedPreferenc sharedPreferenc;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnSave.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnGo.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    public void init(){
        chk1=findViewById(R.id.chk1);
        etIsım=findViewById(R.id.etIsım);
        btnDelete=findViewById(R.id.btnDelete);
        btnGo=findViewById(R.id.btnGo);
        btnRemove=findViewById(R.id.btnRemove);
        btnSave=findViewById(R.id.btnSave);
        sharedPreferenc=new SharedPreferenc();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                if (chk1.isChecked())
                {
                    text=etIsım.getText().toString();
                    sharedPreferenc.save(context,text);
                    Toast.makeText(context, "kaydedildii", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDelete:
                sharedPreferenc.clear(context);
                Toast.makeText(context, "silindii", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnRemove:
                sharedPreferenc.remove(context);
                Toast.makeText(context, "kaldırıldııı", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnGo:
                Intent intent=new Intent(context,SecondActivity.class);
                startActivity(intent);
                break;

        }

    }
}