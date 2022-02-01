package com.example.seceneklialertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> array=new ArrayList<>();
        final CharSequence items[] = {"Windows", "Pardus", "MacOs", "Linux"};
        boolean chechkedItems[] = {true, false, false, true};

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("İşletim sistemi tercihiniz nedir? ");
        alertDialog.setMultiChoiceItems(items, chechkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //her checkbox isaretlendiğinde veya secim kaldırıldığında tetiklenir
                if (isChecked)
                {
                    array.add(items[which].toString());
                    Toast.makeText(context, items[which], Toast.LENGTH_SHORT).show();
                }
                else
                {
                    array.remove(items[which].toString());
                }
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //tamam a basınca tetiklenir
                Toast.makeText(context, "Seçtikleriniz \n"+ array, Toast.LENGTH_SHORT).show();
            }
        }).show();

    }
}