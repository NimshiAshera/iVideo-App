package com.example.ivideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCartActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3;
    TextView email;
    Button b1,b3;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_cart);

        email = (TextView) findViewById(R.id.email);
        email.setText(Demo.message);



        db = new DatabaseHelper(this);

        e1 = (EditText) findViewById(R.id.mname);

        e2 = (EditText) findViewById(R.id.mqnt);

        e3 = (EditText) findViewById(R.id.mprice);

        b1 = (Button) findViewById(R.id.cart);
        b3 = (Button) findViewById(R.id.viewCart);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCartActivity.this,ViewCartActivity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String s1 = e1.getText().toString();

                String s2 = e2.getText().toString();

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
