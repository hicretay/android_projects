package com.example.basicactivity;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.action_settings:
//                Toast.makeText(context, "Ayarlar tıklandı", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.action_save:
//                Toast.makeText(context, "Kaydet tıklandı", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_quit:
//                Toast.makeText(context, "Çıkış tıklandı", Toast.LENGTH_SHORT).show();
//                break;
//        }

        return super.onOptionsItemSelected(item);
    }
    //menuItemlera aynı onClick verilmesi onOptionsItemSelected ile aynı işi yapar
    public void mnu_click(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(context, "Ayarlar tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_save:
                Toast.makeText(context, "Kaydet tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_quit:
                Toast.makeText(context, "Çıkış tıklandı", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}