package com.example.ivideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMovieActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1,e2,e3,e4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        db = new DatabaseHelper(this);

        e1 = (EditText) findViewById(R.id.vid);
        e2 = (EditText) findViewById(R.id.vname);
        e3 = (EditText) findViewById(R.id.num);
        e4 = (EditText) findViewById(R.id.price);
        b1 = (Button) findViewById(R.id.add);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();

                if(s1.equals("")|| s2.equals("")|| s3.equals("")|| s4.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Content(View view) {
        Intent intent = new Intent(this,ContentActivity.class);
        startActivity(intent);
    }
}
