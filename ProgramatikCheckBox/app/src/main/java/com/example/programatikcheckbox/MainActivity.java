package com.example.programatikcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTaksitSayisi;
    LinearLayout pnlTaksitSayisi,pnlTaksitler;
    RadioGroup radioGrp;
    RadioButton radioTaksit,radioTekCekim;
    String giris;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ekran yatay dikeyliği
//        WindowManager vm=(WindowManager)getSystemService(WINDOW_SERVICE);
//        Display dsp=vm.getDefaultDisplay();
//        if(dsp.getHeight()>dsp.getWidth())
//        {
//            setContentView(R.layout.activity_main);  //dik görünüm
//        }
//        else if(dsp.getWidth()>dsp.getHeight())
//        {
//            setContentView(R.layout.landscape); // yatay görünüm
//        }

        setContentView(R.layout.activity_main);
        init();
        radioTekCekim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(radioTekCekim.isChecked())
                {
                    pnlTaksitSayisi.setVisibility(View.INVISIBLE);
                    pnlTaksitler.setVisibility(View.INVISIBLE);
                    etTaksitSayisi.setText("");
                    pnlTaksitler.removeAllViews();
                }
                else if(radioTaksit.isChecked())
                {
                    pnlTaksitSayisi.setVisibility(View.VISIBLE);
                    pnlTaksitler.setVisibility(View.VISIBLE);
                    //etTaksitSayisi.setText("");

                }
            }
        });

        etTaksitSayisi.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_DEL){
                    pnlTaksitler.removeAllViews();
                }
                return false;
            }
        });
    }
    public void btnTaksitlendir_Click(View v) //bahsi gecen buton
    {
       giris= etTaksitSayisi.getText().toString();
       if(giris.matches(""))
       {
           Toast.makeText(context, "Sayısal değer giriniz!!", Toast.LENGTH_SHORT).show();
           return;
       }

        pnlTaksitler.setVisibility(View.VISIBLE);
        pnlTaksitler.removeAllViews();

       int taksitSayisi=Integer.parseInt(etTaksitSayisi.getText().toString());
//       etTaksitSayisi.setText("");
//       etTaksitSayisi.requestFocus();

       if(taksitSayisi >0)
       {
           //programatik checkBoxların olusturulması
           for(int i=1;i<=taksitSayisi;i++)
           {
               CheckBox chk=new CheckBox(context);
               chk.setText(i+". Taksit");
               
               //checkBoxlar icin eventHandler(olay yakalama)
               chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                       if(isChecked)
                       {
                           Toast.makeText(context, buttonView.getText(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });
               pnlTaksitler.addView(chk);
           }
       }

    }

    public void init()
    {
        etTaksitSayisi=findViewById(R.id.etTaksitSayisi);
        pnlTaksitSayisi=findViewById(R.id.pnlTaksitSayisi);
        pnlTaksitler=findViewById(R.id.pnlTaksitler);
        radioGrp=findViewById(R.id.radioGrp);
        radioTaksit=findViewById(R.id.radioTaksit);
        radioTekCekim=findViewById(R.id.radioTekCekim);

    }
}