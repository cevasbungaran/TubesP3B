package com.example.tubesdokter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentPertemuanBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PertemuanFragment extends Fragment implements View.OnClickListener {
    private FragmentPertemuanBinding binding;
    protected PenyimpananNilaiDisplay catat;
    private static final String FILE_NAME = "pertemuanDokter.txt";
    public PertemuanFragment(){

    }

    public static PertemuanFragment newInstance(){
        PertemuanFragment fragment = new PertemuanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentPertemuanBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();
        catat = new PenyimpananNilaiDisplay(getContext());
        return view;
    }
    public void onPause(){
        super.onPause();
        this.catat.saveNamaUSer(this.binding.etPertemuanNama.getText().toString());
        this.catat.saveKeluhan(this.binding.etPertemuanKeluhan.getText().toString());
        this.catat.saveTanggal(this.binding.formTanggal.getText().toString());
        this.catat.saveWaktu(this.binding.formWaktu.getText().toString());
    }

    @Override
    public void onResume(){
        super.onResume();
        binding.etPertemuanNama.setText(this.catat.getNamaUserr());
        binding.etPertemuanKeluhan.setText(this.catat.getKeluhan());
        binding.formTanggal.setText(this.catat.getTanggal());
        binding.formWaktu.setText(this.catat.getwaktu());
    }

    @Override
    public void onClick(View v) {
        if(v == this.binding.btnSimpanPertemuan){
            String namaUser = this.binding.etPertemuanNama.getText().toString();
            String keluhan = this.binding.etPertemuanKeluhan.getText().toString();
            String tanggal = this.binding.formTanggal.getText().toString();
            String waktu = this.binding.formWaktu.getText().toString();
            FileOutputStream fos = null;
            File file;
            try {
                file = new File(getFilesDir() + "pertemuanDokter.txt");
                fos = new FileOutputStream(file);
                if(!file.exists()){
                    file.createNewFile();
                }
                fos.write(namaUser.getBytes());
                fos.write(keluhan.getBytes());
                fos.write(tanggal.getBytes());
                fos.write(waktu.getBytes());
                //Toast.makeText(this,"Saved to" + getFilesDir() + "/" + FILE_NAME,Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fos !=null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private File getFilesDir() {
        return null;
    }
}
