package com.example.akshar.largejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Akshar on 8/31/2017.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Bean>arrayList;
    Context context;

    public MyAdapter(Context context,ArrayList<Bean> arrayList ) {
        this.arrayList = arrayList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.my_layout,null);


        TextView txtseries,txtlongitude,txtlatitude,txtlocality,txtnationality;

        txtseries=(TextView)convertView.findViewById(R.id.txtserise);
        txtlatitude=(TextView)convertView.findViewById(R.id.txtlatitude);
        txtlongitude=(TextView)convertView.findViewById(R.id.txtLogitude);
        txtlocality=(TextView)convertView.findViewById(R.id.txtlocality);
        txtnationality=(TextView)convertView.findViewById(R.id.txtnationality);

        Bean bean  = arrayList.get(position);
        txtseries.setText("Series = "+bean.getSeries());
        txtlatitude.setText("latitute = "+bean.getLat());
        txtlongitude.setText("longitude = "+bean.getLongitute());
        txtlocality.setText("locality = "+bean.getLocality());
        txtnationality.setText("netionality = " +bean.getNationaliti());
        return convertView;
    }
}
