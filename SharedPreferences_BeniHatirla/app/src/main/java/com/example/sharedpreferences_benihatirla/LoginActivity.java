package com.example.sharedpreferences_benihatirla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etUserName,etPassword;
    CheckBox chkRememberMe;
    Button btnLogin;
    SharedPreferenc sharedPreferenc;  //SharedPreferenc sınıfından örneklem alma
    Context context=this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        if (sharedPreferenc.getValueBoolean(context,"remember")) //beni hatırla isaretliyse
        {
            etUserName.setText(sharedPreferenc.getValue(context,"username"));
            chkRememberMe.setChecked(sharedPreferenc.getValueBoolean(context,"remember"));
        }
    }

    public  void init()
    {
        etPassword=findViewById(R.id.etPassword);
        etUserName=findViewById(R.id.etUserName);
        chkRememberMe=findViewById(R.id.chkRememberMe);
        btnLogin=findViewById(R.id.btnLogin);
        sharedPreferenc=new SharedPreferenc(); //SharedPreferenc sınıfından nesne olusturma.
                                               // sınıfın tüm metot ve özellikleri kullanılabilir

        btnLogin.setOnClickListener(new View.OnClickListener() {  //btnLogine e tıklandıgından neler olacak
            @Override
            public void onClick(View v) {
                if (etUserName.getText().toString().equals(getString(R.string.test_username))&&
                        etPassword.getText().toString().equals(getString(R.string.test_password)))
                {
                    Intent intnt=new Intent(context,MainActivity.class);
                    startActivity(intnt);
                    if (chkRememberMe.isChecked())
                    {
                        sharedPreferenc.save(context,"username",etUserName.getText().toString());
                    }
                    else
                    {
                        sharedPreferenc.save(context,"username","");
                    }
                    sharedPreferenc.saveBoolean(context,"remember",chkRememberMe.isChecked());
                }
                else
                {
                    Toast.makeText(context, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
