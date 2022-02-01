package com.example.listview_edittextfilter;

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
    LayoutInflater inflater;
    List<Airport> airportList = new ArrayList<>();
    Context context;  //mainActivity olmadığı için böyle tanımlanır




    @Override
    public int getCount() {
        return airportList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(context);
        View satir = inflater.inflate(R.layout.satir, null);

        ImageView imageView=satir.findViewById(R.id.img);
        TextView txtName=satir.findViewById(R.id.txtName);
        TextView txtLocation=satir.findViewById(R.id.txtLocation);

        Airport airport=airportList.get(position);
        imageView.setBackgroundResource(airport.getImgSrc());
        txtName.setText(airport.getName()+"("+airport.getCode()+")");
        txtLocation.setText(airport.getCity()+"-"+airport.getCountry());

        return satir;
    }

    public CustomAdapter(List<Airport> airportList, Context context) {
        this.airportList = airportList;
        this.context = context;
    }
}
