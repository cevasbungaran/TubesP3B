package com.example.tubesdokter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentPertemuanBinding;

public class PertemuanFragment extends Fragment {
    private FragmentPertemuanBinding binding;
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

        return view;
    }
}
