package com.example.startactivityforresaultintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etX,etY;
    TextView txtSonuc;
    Button btnDegerYolla;
    Context context=this;
    static  final int Contact_Request=1; // sabit deger verilip kontrol edilerek alınır



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etX=findViewById(R.id.etX);
        etY=findViewById(R.id.etY);
        txtSonuc=findViewById(R.id.txtSonuc);
        btnDegerYolla=findViewById(R.id.btnDegerYolla);

        btnDegerYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,AnotherActivity.class);
                intent.putExtra("x",etX.getText().toString());
                intent.putExtra("y",etY.getText().toString());
                startActivityForResult(intent,Contact_Request);
            }
        });
    }
    //dönen değeri yakalama
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==Contact_Request)
        {
            if (requestCode==RESULT_OK)
            {
                txtSonuc.setText(String.valueOf(data.getIntExtra("toplam",-1)));
            }
            else if (requestCode==RESULT_CANCELED)
            {
                Toast.makeText(context, "beklenmedik bir şekilde sonlandı", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}