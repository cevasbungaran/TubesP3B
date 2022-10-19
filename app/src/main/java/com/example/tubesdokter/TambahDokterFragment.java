package com.example.tubesdokter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentMainBinding;
import com.example.tubesdokter.databinding.FragmentTambahDokterBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TambahDokterFragment extends Fragment implements View.OnClickListener {
    private FragmentTambahDokterBinding binding;
    protected PenyimpananNilaiDisplay catat;
    public TambahDokterFragment(){

    }

    public static TambahDokterFragment newInstance(){
        TambahDokterFragment fragment = new TambahDokterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentTambahDokterBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();
        catat = new PenyimpananNilaiDisplay(getContext());
        return view;

    }

    @Override
    public void onPause(){
        super.onPause();
        this.catat.saveNamaDokter(this.binding.etTambahNama.getText().toString());
        this.catat.saveSpesialisasi(this.binding.etTambahSpesialisasi.getText().toString());
    }

    @Override
    public void onResume(){
        super.onResume();
        binding.etTambahNama.setText(this.catat.getNamaDokter());
        binding.etTambahSpesialisasi.setText(this.catat.getSpesialisasi());
    }

    @Override
    public void onClick(View v) {
        if(v == this.binding.btnSimpan){
            String namaDokter = this.binding.etTambahNama.getText().toString();
            String spesialisasi = this.binding.etTambahSpesialisasi.getText().toString();
            FileOutputStream fos = null;
            File file;
            try {
                file = new File(getFilesDir() + "tambahDokter.txt");
                fos = new FileOutputStream(file);
                if(!file.exists()){
                    file.createNewFile();
                }
                fos.write(namaDokter.getBytes());
                fos.write(spesialisasi.getBytes());
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
