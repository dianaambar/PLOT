package com.example.android.plot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Search extends AppCompatActivity {
    ImageButton btnPlaces;
    ImageButton btnCulinaries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //Intent intent = new Intent();
        //intent.setClass(Search.this, Register.class);
        //startActivity(intent);

        btnPlaces = (ImageButton)findViewById(R.id.btnPlaces);
        btnCulinaries = (ImageButton) findViewById(R.id.btnCulinary);

        btnPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Search.this, Places.class);
                startActivity(intent);
            }
        });

        btnCulinaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Search.this, Culinaries.class);
                startActivity(intent);
            }
        });

    }
}
