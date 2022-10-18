package com.example.tubesdokter;

public class Dokter {
    private String nama;
    private String spesial;

    public Dokter (String nama,String spesial){
        this.nama = nama;
        this.spesial = spesial;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String Nama) {
        this.nama = nama;
    }

    public String getSpesial() {
        return spesial;
    }

    public void setSpesial(String spesial) {
        this.spesial = spesial;
    }

}
