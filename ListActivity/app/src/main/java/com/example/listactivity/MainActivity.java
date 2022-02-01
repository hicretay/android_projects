package com.example.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String os[];
    ArrayAdapter<String> adp;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        os=new String[5];
        os[0]="Solaris";
        os[1]="Pardus";
        os[2]="Ubuntu";
        os[3]="MacOs";
        os[4]="Linux";

        adp=new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,
                android.R.id.text1,os);
        setListAdapter(adp);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(context, os[position], Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}