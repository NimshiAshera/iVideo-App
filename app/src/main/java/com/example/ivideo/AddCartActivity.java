package com.example.ivideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCartActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e3;
    Spinner e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        Spinner dropdown = findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] items = new String[]{"240p", "360p", "480p", "720p"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);



        db = new DatabaseHelper(this);

        e1 = (EditText) findViewById(R.id.mname);
        e2 = (android.widget.Spinner) findViewById(R.id.spinner1);
        e3 = (EditText) findViewById(R.id.mprice);
        b1 = (Button) findViewById(R.id.cart);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getSelectedItem().toString();
                String s3 = e3.getText().toString();


                if(s1.equals("")|| s2.equals("")|| s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void ViewMovie(View view) {
        Intent intent = new Intent(this,MovieViewActivity.class);
        startActivity(intent);
    }


}
