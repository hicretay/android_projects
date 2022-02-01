package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner_1,spinner_2;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_1=findViewById(R.id.spinner_1);
        spinner_2=findViewById(R.id.spinner_2);

        ArrayList<String> liste=new ArrayList<>();
        liste.add("besiktas");
        liste.add("fenerbahce");
        liste.add("galatasaray");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>
                (context, android.R.layout.simple_list_item_1,liste);
        spinner_2.setAdapter(dataAdapter);

        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"secilen eleman: "+parent.getItemAtPosition(position) , Toast.LENGTH_SHORT).show();
            }
   //hicbir secili eleman yoksa cagrılacak metot
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public  void btnEkle_Click(View v)
    {
        Toast.makeText(context,"secili eleman"+ spinner_2.getSelectedItem(), Toast.LENGTH_SHORT).show();
    }


}