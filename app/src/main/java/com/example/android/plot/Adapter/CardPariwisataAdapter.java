package com.example.android.plot.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.plot.Model.Pariwisata;
import com.example.android.plot.R;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.util.ArrayList;

public class CardPariwisataAdapter extends RecyclerView.Adapter<CardPariwisataAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Pariwisata> list_lokasi;

    public CardPariwisataAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Pariwisata> getList_lokasi() {
        return list_lokasi;
    }

    public void setList_lokasi(ArrayList<Pariwisata> list_lokasi) {
        this.list_lokasi = list_lokasi;
    }

    @NonNull
    @Override
    //nampung layout
    public CardPariwisataAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_places_layout, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    //method buat nge set layoutnya sesuai dengan namanya
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {

        Pariwisata pariwisata = list_lokasi.get(position);

        Glide.with(context)
                .load(pariwisata.getGambar_wisata())
                .into(holder.imgbtnGambarLokasi);

        holder.tvPlacesNamaLokasi.setText(pariwisata.getNama_lokasi());
        holder.tvPlacesTempatLokasi.setText(pariwisata.getLokasi_wisata());
        holder.tvPlacesKategoriLokasi.setText(pariwisata.getKategori_wisata());

    }

    @Override
    //ngambil si list_lokasi yang ada di listnya jumlahnya
    public int getItemCount() {
        return list_lokasi.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{

        TextView tvPlacesNamaLokasi;
        TextView tvPlacesTempatLokasi;
        TextView tvPlacesKategoriLokasi;
        ImageButton imgbtnGambarLokasi;

        //untuk hold apa aja yang ada di card viewnya.
        public CardViewViewHolder(View itemView) {
            super(itemView);
            tvPlacesKategoriLokasi = (TextView) itemView.findViewById(R.id.tvPlacesKategoriTempat);
            tvPlacesTempatLokasi = (TextView) itemView.findViewById(R.id.tvPlacesTempatLokasi);
            tvPlacesNamaLokasi = (TextView) itemView.findViewById(R.id.tvPlacesNamaLokasi);
            imgbtnGambarLokasi = (ImageButton) itemView.findViewById(R.id.imgbtnGambarLokasi);
        }


    }
}
