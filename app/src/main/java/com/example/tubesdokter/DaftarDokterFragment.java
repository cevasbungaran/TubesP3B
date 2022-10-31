package com.example.tubesdokter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentDaftarDokterBinding;

public class DaftarDokterFragment extends Fragment implements View.OnClickListener {
    private FragmentDaftarDokterBinding binding;
    private DaftarDokterAdapter adapter;
    private FragmentListener fragmentListener;
    private DaftarDokterPresenter presenter;
    private Button btnSimpan;
    //private ListView listDokter;
    private EditText nama;
    private EditText spesialisasi;
    public DaftarDokterFragment(){

    }

    public static DaftarDokterFragment newInstance(){
        DaftarDokterFragment fragment = new DaftarDokterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentDaftarDokterBinding.inflate(inflater, container, false);
        this.adapter = new DaftarDokterAdapter(getActivity());
//        this.presenter = new DaftarDokterPresenter((DaftarDokterPresenter.IMainActivity) getContext());
        this.binding.lstDokter.setAdapter(adapter);
        View view = this.binding.getRoot();
        this.binding.btnTambahDokter.setOnClickListener(this);
        return view;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+"Must implement fragment listener");
        }
    }

    @Override
    public void onClick(View view) {
        if (view==this.binding.btnTambahDokter){
            this.fragmentListener.changePage(5);
        }
    }

    /*@Override
    public void updateArray(List<Dokter> dokters) {
        this.adapter.updateArray(dokters);
    }*/
}
