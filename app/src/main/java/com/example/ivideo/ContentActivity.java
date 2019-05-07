package com.example.ivideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    public void AddMovie(View view) {

        Intent intent = new Intent(this,AddMovieActivity.class);
        startActivity(intent);
    }

    public void ViewMovie(View view) {
        Intent intent = new Intent(this,MovieViewActivity.class);
        startActivity(intent);
    }
}
