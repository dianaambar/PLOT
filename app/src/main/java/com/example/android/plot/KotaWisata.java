package com.example.android.plot;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class KotaWisata extends AppCompatActivity {

    ImageButton imgbtnLocationJogja;
    ImageButton imgbtnLocationBali;
    ImageButton imgbtnLocationJakarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota_wisata);

        imgbtnLocationJogja = (ImageButton) findViewById(R.id.imgbtnLocationJogja);
        imgbtnLocationBali = (ImageButton) findViewById(R.id.imgbtnLocationBali);
        imgbtnLocationJakarta = (ImageButton) findViewById(R.id.imgbtnLocationJakarta);

        imgbtnLocationBali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(KotaWisata.this, Search.class);
                startActivity(intent);
            }


        });

        imgbtnLocationJogja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(KotaWisata.this, Search.class);
                startActivity(intent);
            }
        });

        imgbtnLocationJakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(KotaWisata.this, Search.class);
                startActivity(intent);
            }
        });

    }
}
