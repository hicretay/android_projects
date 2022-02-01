package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView liste;
    Context context=this;
    static final String[] meyveler=new String[] {"Elma","Armut","Muz","Seftali","Bogurlen",
            "Hindistan Cevizi","Kivi","Mandalina","Portakal","Yeni Dünya","Karpuz","Kavun","Kiraz","Cilek"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.lvMeyveler);

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,
//                android.R.id.text1,meyveler);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.list_meyve,meyveler);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                dialog.setMessage(meyveler[position]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }
}