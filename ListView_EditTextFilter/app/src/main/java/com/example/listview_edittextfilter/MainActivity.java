package com.example.listview_edittextfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etFilter;
    ListView lst;
    ArrayList<Airport> airports=new ArrayList<>();
    ArrayList<Airport> tempList=new ArrayList<>();
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFilter=findViewById(R.id.etFilter);
        lst=findViewById(R.id.lst);

        airports.add(new Airport("Atatürk Havalimanı","AHL","İstanbul","Türkiye",(R.mipmap.ic_launcher)));
        airports.add(new Airport("Sabiha Gökçen Havalimanı","SAW","İstanbul","Türkiye",(R.mipmap.ic_launcher)));

//        Airport airport=new Airport();
//        airport.setCity("İstanbul");
//        airport.setCode("AHl");              yukarıdaki tanımlamanın baska bir yolu

        CustomAdapter adapter=new CustomAdapter(airports,context);
        lst.setAdapter(adapter);

        //editText i filtreleme
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tempList.clear();
                s=s.toString().toUpperCase();
                for (int i=0;i<airports.size();i++)
                {
                    Airport tempPort=airports.get(i);
                    if (tempPort.getCountry().toUpperCase().contains(s)||
                            tempPort.getCode().toUpperCase().contains(s)||
                            tempPort.getCity().toUpperCase().contains(s)||
                            tempPort.getName().toUpperCase().contains(s))
                    {
                        tempList.add(tempPort);
                    }
                }
                if (tempList!=null &&tempList.size()>0)
                {
                    CustomAdapter adapter=new CustomAdapter(tempList,context);
                    lst.setAdapter(adapter);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }}