package com.example.klavyemesajlari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    EditText etBaslangic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBaslangic=findViewById(R.id.etBaslangic);

        etBaslangic.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) { //v= kullanılan eleman burda edittext
                if (event.getAction()==KeyEvent.ACTION_DOWN&& keyCode==KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(context, etBaslangic.getText(), Toast.LENGTH_SHORT).show();
                    return  true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}