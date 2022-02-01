package com.example.listviewcontextmenuiliskilendirme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView durum;
    ListView list;
    Context context = this;
    static final int ID_SIL = Menu.FIRST;
    static final int ID_DUZENLE = Menu.FIRST + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        durum = findViewById(R.id.durum);
        list = findViewById(R.id.list);

        String[] isimler = getResources().getStringArray(R.array.names);  //string dizisini alma

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.list_item,isimler);   //TextView tasarımını yükleme
        list.setAdapter(adapter);

        //Context menu olusturma
        registerForContextMenu(list);  // 1. list isimli listView bir context menuye sahip demek
    }

    // 2. hangi kontrol hangi menuye sahip
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //ListView e tıklandığında görüntülenecek menunun itemları
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, ID_SIL, 0, "Sil");
        menu.add(Menu.NONE, ID_DUZENLE, 1, "Düzenle");
    }

    // 3. menu ıtemlarına tıklanınca ne olacak
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //tıklanan textViewdeki değeri okuma
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView seciliItem = (TextView) info.targetView;


        // menu itemlarının seçimi
        if (item.getItemId() == ID_SIL) {
            durum.setText(seciliItem.getText() + "için sil tıklandı");
            return true;
        }
        if (item.getItemId() == ID_DUZENLE) {
            durum.setText(seciliItem.getText() + "için düzenle tıklandı");
            return true;
        }
        return false;
    }
}