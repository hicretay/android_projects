package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MobileOS> mobile=new ArrayList<>();
    ListView liste;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=findViewById(R.id.liste);

        mobile.add(new MobileOS("IOS"));
        mobile.add(new MobileOS("Blackberry"));
        mobile.add(new MobileOS("Windows Phone"));
        mobile.add(new MobileOS("Android"));

        CustomAdapter adapter=new CustomAdapter(context,mobile);
        liste.setAdapter(adapter);
    }
}