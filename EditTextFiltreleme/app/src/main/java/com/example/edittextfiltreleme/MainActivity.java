package com.example.edittextfiltreleme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFilter;
    String beforeTextChanged = "", onTextChanged = "", afterTextChanged = "";
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFilter = findViewById(R.id.etFilter);
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //editTextte değisim yapmadan önce

                beforeTextChanged = etFilter.getText().toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //editTextte değisim yaparken

                onTextChanged = etFilter.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable s) {
                //editTextte değisim yaptıktan sonra

                afterTextChanged = etFilter.getText().toString();
                Toast.makeText(context, "before :"+beforeTextChanged
                        +"\n"+"on: "+onTextChanged+"\n"+"after: "+afterTextChanged,Toast.LENGTH_SHORT).show();

            }
        });
    }
}