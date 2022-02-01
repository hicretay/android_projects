package com.example.togglebutton;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SwitchClass extends AppCompatActivity {
    Switch aSwitch;
    Button btnGoster;
    TextView txtSonuc;
    Context context=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_control);

        aSwitch= findViewById(R.id.aSwitch);
        btnGoster=findViewById(R.id.btnGoster);
        txtSonuc=findViewById(R.id.txtSonuc);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            aSwitch.setShowText(true);
        }

//        btnGoster.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(aSwitch.isChecked()){
//                    Toast.makeText(SwitchClass.this, "switch secili", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(SwitchClass.this, "switch secili degil", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //switch butonu degisince calısacak olaylar
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton switchimiz, boolean isChecked) {
//                if(isChecked){
//                    txtSonuc.setText((aSwitch.getTextOn()));
//                }
//                else{
//                    txtSonuc.setText((aSwitch.getTextOff()));
//                   // switchimiz.setEnabled(false);
//                }
//            }
//        });

        //switch durumu degistiginde durumunun yakalanması (buton gibi davranması saglanır)
//        aSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {  //v: bahsi gecen switch kontrolu
//               if(((Switch)v).isChecked()) {
//                    txtSonuc.setText((aSwitch.getTextOn()));
//                }
//               else{
//                   txtSonuc.setText((aSwitch.getTextOff()));
//               }
//
//            }
//        });

    }
}
