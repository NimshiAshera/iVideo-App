package com.example.ivideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MovieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);

    }

    public void AddCart(View view) {
        Intent intent = new Intent(this,AddCartActivity.class);
        startActivity(intent);
    }
}
