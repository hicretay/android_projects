package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenc {
    static final String PREF_NAME="Dosya";
    static final String PREF_KEY="Key";


    public  void save(Context context,String text){      //Kaydetme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString(PREF_KEY,text);
        editor.commit();
    }

    public String getValue(Context context){        //Kaydedilen değeri elde etme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String text=settings.getString(PREF_KEY,null);   //key-value içine verilerin eklenmesi
        return  text;
    }

    public  void clear(Context context){   //tüm değerleri temizleme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.clear();
        editor.commit();
    }

    public  void remove(Context context){   //değeri kaldırma
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.remove(PREF_KEY);
        editor.commit();
    }
}
