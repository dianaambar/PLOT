package com.example.android.plot.Model;

public class Pariwisata {

    private String gambar_wisata;
    private String nama_lokasi;
    private String lokasi_wisata;
    private String kategori_wisata;

    public Pariwisata(String gambar_wisata, String nama_lokasi, String lokasi_wisata, String kategori_wisata) {
        this.gambar_wisata = gambar_wisata;
        this.nama_lokasi = nama_lokasi;
        this.lokasi_wisata = lokasi_wisata;
        this.kategori_wisata = kategori_wisata;
    }

    public Pariwisata() {
    }

    public String getGambar_wisata() {
        return gambar_wisata;
    }

    public void setGambar_wisata(String gambar_wisata) {
        this.gambar_wisata = gambar_wisata;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getLokasi_wisata() {
        return lokasi_wisata;
    }

    public void setLokasi_wisata(String lokasi_wisata) {
        this.lokasi_wisata = lokasi_wisata;
    }

    public String getKategori_wisata() {
        return kategori_wisata;
    }

    public void setKategori_wisata(String kategori_wisata) {
        this.kategori_wisata = kategori_wisata;
    }
}
