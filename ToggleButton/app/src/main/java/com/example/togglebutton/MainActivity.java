package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    StringBuffer sonuc;
    ToggleButton toggleButton;
    Button buton;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton=findViewById(R.id.toggle);
        buton=findViewById(R.id.buton);

        //herhangi bir buton tıklandığında toggle butonun secili olup olmamasına gore farklı tepkiler verilmesi icin;
//        buton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sonuc=new StringBuffer();
//                if(toggleButton.isChecked()){
//                    sonuc.append("Toggle").append("Buton").append("secili");
//                    Toast.makeText(context,sonuc.toString(), Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(context, "toggle seçili degil", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //toggle butonun durumu her degistiginde olacak olaylar
//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                 sonuc=new StringBuffer();
//
//                if(isChecked){
//                    sonuc.append("Toggle").append("Buton").append("secili");
//                    Toast.makeText(context,sonuc.toString(), Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(context, "toggle seçili degil", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });

        //toggle buton tıklandıgında secili olup olmamasına gore farklı mesaj vermek için
//        toggleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean durum=((ToggleButton)v).isChecked();
//                if(durum==true){
//                    Toast.makeText(context, "Secili", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(context, " secili degil", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}