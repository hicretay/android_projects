package com.example.contextmenuor;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ContextMenu;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);

        this.registerForContextMenu(et1);  //et1 in context menusu
        this.registerForContextMenu(et2);  //et2 nin context menusu

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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId())
        {
            case R.id.et1:
                getMenuInflater().inflate(R.menu.renk_menu,menu);
                break;
            case R.id.et2:
                getMenuInflater().inflate(R.menu.font_menu,menu);
                break;
        }
    }

    //itemların her birine tıklandığında neler olacak  belirler
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            //renk menusu için
            case R.id.mnu_blue:
                et1.setTextColor(Color.BLUE);
                break;
            case R.id.mnu_green:
                et1.setTextColor(Color.GREEN);
                break;
            case R.id.mnu_red:
                et1.setTextColor(Color.RED);
                break;

             //font menusu icin
            case R.id.mnu_big:
                et2.setTextSize(50);
                break;
            case R.id.mnu_medium:
                et2.setTextSize(35);
                break;
            case R.id.mnu_small:
                et2.setTextSize(20);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}