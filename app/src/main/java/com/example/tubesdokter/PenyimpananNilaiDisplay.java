package com.example.tubesdokter;

import android.content.Context;
import android.content.SharedPreferences;

public class PenyimpananNilaiDisplay {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF="sp_nilai_display";
    protected final static String KEY_NAMA_DOKTER="DOKTER";
    protected final static String KEY_SPESIALISASI="SPESIALISASI";
    protected final static String KEY_NAMA_USER="USER";
    protected final static String KEY_KELUHAN="KELUHAN";
    protected final static String KEY_TANGGAL="TANGGAL";
    protected final static String KEY_WAKTU="WAKTU";

    public PenyimpananNilaiDisplay(Context context){
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveNamaDokter(String dokter){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_NAMA_DOKTER,dokter);
        editor.commit();
    }
    public void saveSpesialisasi(String spesialisasi){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_SPESIALISASI,spesialisasi);
        editor.commit();
    }
    public void saveNamaUSer(String user){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_NAMA_USER,user);
        editor.commit();
    }
    public void saveKeluhan(String keluhan){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_KELUHAN,keluhan);
        editor.commit();
    }
    public void saveTanggal(String tanggal){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_TANGGAL,tanggal);
        editor.commit();
    }
    public void saveWaktu(String waktu){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_WAKTU,waktu);
        editor.commit();
    }

    public String getNamaDokter(){
        return sharedPref.getString(KEY_NAMA_DOKTER,"");
    }
    public String getSpesialisasi(){
        return sharedPref.getString(KEY_SPESIALISASI,"");
    }
    public String getNamaUserr(){
        return sharedPref.getString(KEY_NAMA_USER,"");
    }
    public String getKeluhan(){
        return sharedPref.getString(KEY_KELUHAN,"");
    }
    public String getTanggal(){
        return sharedPref.getString(KEY_TANGGAL,"");
    }
    public String getwaktu(){
        return sharedPref.getString(KEY_WAKTU,"");
    }
}
