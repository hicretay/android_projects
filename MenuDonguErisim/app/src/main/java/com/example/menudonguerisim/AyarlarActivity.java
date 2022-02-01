package com.example.menudonguerisim;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AyarlarActivity extends AppCompatActivity {
    Context context=this;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ArrayList<String> menuItem=new ArrayList<>();
        menuItem.add("File");
        menuItem.add("Edit");
        menuItem.add("Window");
        menuItem.add("Help");
        menuItem.add("About");
        for (String t:menuItem)
        {
            MenuItem menuItem1=menu.add(t);
            menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                    return  true;
                }
            });

        }

        return super.onCreateOptionsMenu(menu);

    }
}
