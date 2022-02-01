package com.example.sharedpreferences_benihatirla;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenc {
    static final String PREF_NAME="Login";

    public  void save(Context context, String key,String value){      //string bir değer Kaydetme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public  void saveBoolean(Context context, String key,Boolean value){      // checkBox i kaydetmek için (t/f)
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public String getValue(Context context,String key){        //Kaydedilen string değeri elde etme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String text=settings.getString(key,null);   //key-value içine verilerin eklenmesi
        return  text;
    }

    public Boolean getValueBoolean(Context context,String key){        //Kaydedilen boolean değeri elde etme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        Boolean text=settings.getBoolean(key,false);   //key-value içine verilerin eklenmesi
        return  text;
    }

    public  void clear(Context context){   //tüm değerleri temizleme
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.clear();
        editor.commit();
    }

    public  void remove(Context context,String key){   //değeri kaldırma
        SharedPreferences settings=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.remove(key);
        editor.commit();
    }
}
