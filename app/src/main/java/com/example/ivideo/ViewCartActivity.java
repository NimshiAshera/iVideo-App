package com.example.ivideo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewCartActivity extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList <Cart> cartList;
    ListView listView;
    Cart cart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contents_layout);

        db = new DatabaseHelper(this);

        cartList = new ArrayList<>();

        Cursor data = db.viewCart();
        int numRows = data.getCount();

        if(numRows==0){
            Toast.makeText(ViewCartActivity.this,"Cart is empty",Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                cart = new Cart(data.getString(1),data.getString(2),data.getString(3));
                cartList.add(cart);
            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this,R.layout.list_adapter_view,cartList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);

        }
    }
}

