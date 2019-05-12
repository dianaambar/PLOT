
package com.example.android.plot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Culinaries extends AppCompatActivity {
    ImageButton imgbtnBIKU;
    ImageButton imgbtnWarungOcha;
    ImageButton imgbtnTheLawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinaries);

        imgbtnBIKU = (ImageButton) findViewById(R.id.imgbtnBIKU);
        imgbtnWarungOcha = (ImageButton) findViewById(R.id.imgbtnWarungOcha);
        imgbtnTheLawn = (ImageButton) findViewById(R.id.imgbtnTheLawn);

        imgbtnBIKU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BIKU = new Intent();
                BIKU.setClass(Culinaries.this, Culinary1.class);
                startActivity(BIKU);
            }
        });

        imgbtnWarungOcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent warungocha = new Intent();
                warungocha.setClass(Culinaries.this, WarungOcha.class);
                startActivity(warungocha);
            }
        });

        imgbtnTheLawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thelawn = new Intent();
                thelawn.setClass(Culinaries.this, TheLawn.class);
                startActivity(thelawn);
            }
        });
    }
}
