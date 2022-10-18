package com.example.tubesdokter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentMainBinding;
import com.example.tubesdokter.databinding.FragmentTambahDokterBinding;

public class TambahDokterFragment extends Fragment {
    private FragmentTambahDokterBinding binding;
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


        return view;
    }
}
