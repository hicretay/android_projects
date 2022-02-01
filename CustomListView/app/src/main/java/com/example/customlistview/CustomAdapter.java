package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<MobileOS> mobile=new ArrayList<>();
    LayoutInflater inflater;
    Context context;

    public CustomAdapter(Context _context,List<MobileOS> _mobile) {
        this.context=_context;
        this.mobile = _mobile;
    }

    @Override
    public int getCount() {
        //listViewda gösterilecek satır sayısı
        return mobile.size();
    }

    @Override
    public Object getItem(int position) {
        //Position ile sırası gelen eleman döndürülür
        return position;
    }

    @Override
    public long getItemId(int position) {
        //varsa niteleyici id bilgisi
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Position ile sirası gelen satır için bir view döndürür
        inflater=LayoutInflater.from(context);
        View satir=inflater.inflate(R.layout.satir,null);
        TextView textView=satir.findViewById(R.id.txtLogo);
        ImageView image=satir.findViewById(R.id.logo);

        MobileOS mobileOS=mobile.get(position);
        textView.setText(mobileOS.getAdi());

        //isme göre iconlar
        if (mobileOS.getAdi().equals("IOS"))
        {
            image.setImageResource(R.mipmap.ic_launcher);
        }
        else if(mobileOS.getAdi().equals("Blackberry"))
        {
            image.setImageResource(R.mipmap.ic_launcher);
        }
        else if(mobileOS.getAdi().equals("Windows Phone"))
        {
            image.setImageResource(R.mipmap.ic_launcher);
        }
        else if(mobileOS.getAdi().equals("Android"))
        {
            image.setImageResource(R.mipmap.ic_launcher);
        }

        return satir;
    }
}
