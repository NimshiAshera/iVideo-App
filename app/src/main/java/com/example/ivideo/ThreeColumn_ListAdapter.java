package com.example.ivideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<Cart> {

    private LayoutInflater ainflater;
    private ArrayList<Cart> carts;
    private  int aViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId,ArrayList<Cart> carts){
        super(context,textViewResourceId,carts);
        this.carts = carts;
        ainflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        aViewResourceId = textViewResourceId;


    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = ainflater.inflate(aViewResourceId,null);

        Cart cart = carts.get(position);

        if(cart !=null){
            TextView mname = (TextView) convertView.findViewById(R.id.mname);
            TextView mqnt = (TextView) convertView.findViewById(R.id.mqnt);
            TextView mprice = (TextView) convertView.findViewById(R.id.mprice);

        if(mname != null){
            mname.setText(cart.getName());
        }
        if(mqnt != null){
            mqnt.setText(cart.getQuality());
        }
        if(mprice != null){
            mprice.setText(cart.getPrice());
        }
        }
        return convertView;
    }
}
