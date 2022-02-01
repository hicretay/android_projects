package com.example.anket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etSurname;
    RadioGroup radioMedeni;
    RadioButton radioEvli,radioBekar;
    Switch swHobi;
    CheckBox chkSpor,chkDans,chkMüzik,chkSinema;
    GridLayout gridHobi;
    Button btnYazdir;
    TextView txtSonuc;
    Context context=this;
    StringBuffer sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        swHobi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    gridHobi.setVisibility(View.VISIBLE);
                }
                else
                {
                    gridHobi.setVisibility(View.GONE);
                    replaceCheck(gridHobi);  //hepsini false yapar
                    txtSonuc.setText("");
                    sonuc.delete(0,sonuc.length());
                }
            }
        });
        btnYazdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSonuc.setText("");
                sonuc.delete(0,sonuc.length());
                if(etName.getText().toString().isEmpty()&&etName.getText().toString().equals(""))
                {
                    Toast.makeText(context, "Lütfen Isim Giriniz", Toast.LENGTH_SHORT).show();
                    return; // isim girilmezse devamını da yazdırmaması cıkması ıcın
                }
                else
                {
                    sonuc.append("Ismıniz: "+etName.getText());
                    etName.setText("");
                    etName.requestFocus();
                }
                if(etSurname.getText().toString().isEmpty()&&etSurname.getText().toString().equals(""))
                {
                    Toast.makeText(context, "Lütfen Soyisim Giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    sonuc.append("\nSoyisminiz: "+etSurname.getText());
                    etSurname.setText("");
                }
                //medeni durum
//                int secilenRadyo=radioMedeni.getCheckedRadioButtonId();
//                switch (secilenRadyo){
//                    case R.id.radioEvli:
//                        sonuc.append("\nMedeni Durumu: Evli");
//                        break;
//                    case R.id.radioBekar:
//                        sonuc.append("\nMedeni Durumu: Bekar");
//                        break;
//                }

                //if ile yapma
                if(radioEvli.isChecked())
                {
                        sonuc.append("\nMedeni Durumu: "+radioEvli.getText());
                }
                else if(radioBekar.isChecked())
                {
                        sonuc.append("\nMedeni Durumu: "+radioBekar.getText());
                }

                //hobiler
                String hobi="";
                if(chkDans.isChecked())
                {
                    hobi+="Dans ";
                }
                if(chkMüzik.isChecked())
                {
                    hobi+="Müzik ";
                }
                if(chkSinema.isChecked())
                {
                    hobi+="Sinema ";
                }
                if(chkSpor.isChecked())
                {
                    hobi+="Spor ";
                }

                //hobileri yazdırma
                if(hobi.equals("")&&hobi.isEmpty())
                {
                    sonuc.append("\nHobi yok");
                }
                else
                {
                    sonuc.append("\nHobileriniz : "+hobi);
                }


                //sonucu yazdırma
                txtSonuc.setText(sonuc);

            }
        });

        //editTexte girilen degerleri filtreleme
        
//        etName.setFilters(new InputFilter[]{new InputFilter() {
//            @Override
//            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//                if(source.equals("")){   //geri tusunun calısabilmesi icin
//                    return source;
//                }
//                if(source.toString().matches("[a-zA-Z ]+"))
//                {
//                    return source;
//                }
//                return "";  //birsey yazmaması icin
//            }
//        }});
    }

    public  void init()
    {
        sonuc=new StringBuffer();
        etName=findViewById(R.id.etName);
        etSurname=findViewById(R.id.etSurname);
        radioMedeni=findViewById(R.id.radioMedeni);
        radioEvli=findViewById(R.id.radioEvli);
        radioBekar=findViewById(R.id.radioBekar);
        swHobi=findViewById(R.id.swHobi);
        chkSpor=findViewById(R.id.chkSpor);
        chkDans=findViewById(R.id.chkDans);
        chkMüzik=findViewById(R.id.chkMüzik);
        chkSinema=findViewById(R.id.chkSinema);
        gridHobi=findViewById(R.id.gridHobi);
        btnYazdir=findViewById(R.id.btnYazdir);
        txtSonuc=findViewById(R.id.txtSonuc);
    }

// Tüm checkBoxları false yapmak için metot
    public void replaceCheck(ViewGroup viewTree)
    {
        View child;
        for (int i=0;i<viewTree.getChildCount();++i)
        {
            child=viewTree.getChildAt(i);
            if(child instanceof ViewGroup)
            {
                replaceCheck((ViewGroup)child);
            }
            else if(child instanceof CheckBox)
            {
                ((CheckBox)child).setChecked(false);
            }
        }
    }
}