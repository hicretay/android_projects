package com.example.ulkelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spnCountries;
    ListView lstCities;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCountries=findViewById(R.id.spnCountries);
        lstCities=findViewById(R.id.lstCities);
        spnCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String secilenUlke=spnCountries.getItemAtPosition(position).toString();
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(context, android.R.layout
                        .simple_list_item_1, android.R.id.text1,sehirGel(secilenUlke));
                lstCities.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    ArrayList<String> sehirGel(String ulke)
    {
        ArrayList<String> sehirler=new ArrayList<>();
        switch (ulke)
        {
            case "Turkiye":
                sehirler.add("Ankara");
                sehirler.add("İstanbul");
                sehirler.add("İzmir");
                break;
        }

        switch (ulke)
        {
            case "KKTC":
                sehirler.add("Magusa");
                sehirler.add("Lefkosa");
                sehirler.add("Girne");
                break;
        }

        switch (ulke)
        {
            case "Almanya":
                sehirler.add("Berlin");
                sehirler.add("Hamburg");
                sehirler.add("Koln");
                break;
        }
        return sehirler;
    }
}