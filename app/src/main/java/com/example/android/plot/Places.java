package com.example.android.plot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import java.util.*;

import com.example.android.plot.Adapter.CardPariwisataAdapter;
import com.example.android.plot.Model.Pariwisata;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Places extends AppCompatActivity {

    private static final String TAG = "Places";
    private ArrayList<Pariwisata> pwt_list = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        RecycleCardPariwisata();

    }

    private void RecycleCardPariwisata()
    {
        RecyclerView rcy_places = findViewById(R.id.card_places_rcy);
        rcy_places.setLayoutManager(new GridLayoutManager(this, 1));
        CardPariwisataAdapter cardPariwisataAdapter = new CardPariwisataAdapter(this);
        cardPariwisataAdapter.setList_lokasi(pwt_list);
        rcy_places.setAdapter(cardPariwisataAdapter);
        getDataPariwisataFromDatabase(cardPariwisataAdapter);
    }


    private void getDataPariwisataFromDatabase(final CardPariwisataAdapter adapter)
    {
        //ngambil dari firebase yang nyambung sama emailnya
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //referensi databasenya, dia ngambil data dari tabel pariwisata
        DatabaseReference myRef = database.getReference("pariwisata");
        //interface
        myRef.addValueEventListener(new ValueEventListener() {
            @Override

            //untuk ngambil data dari database
            public void onDataChange(DataSnapshot dataSnapshot) {
                //ngambil data dari databasenya secara satupersatu , looping sampai data yang terakhir
                for (DataSnapshot pariwasataSnapshot : dataSnapshot.getChildren())
                {
                    //ngambil datanya
                    Pariwisata pariwisata = pariwasataSnapshot.getValue(Pariwisata.class);
                    //untuk memasukkan list tempat ke array pwt_list
                    pwt_list.add(pariwisata);
                }
                //untuk prubahan data yang dinamis
                adapter.notifyDataSetChanged();
            }

            @Override
            //kalau terjadi error
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "onCancelled: ", databaseError.toException());
            }
        });
    }
}
