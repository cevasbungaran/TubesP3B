package com.example.tubesdokter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesdokter.databinding.FragmentLeftBinding;

public class LeftFragment extends Fragment implements View.OnClickListener{
    private FragmentListener fragmentListener;
    private FragmentLeftBinding binding;
    public LeftFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentLeftBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        binding.btnHome.setOnClickListener(this);
        binding.btnPertemuan.setOnClickListener(this);
        binding.btnDokter.setOnClickListener(this);
        binding.btnPengaturan.setOnClickListener(this);
        binding.btnExit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener= (FragmentListener) context;
        }else{
            throw new ClassCastException(context.toString()+ " Must Implement Fragment Listener");
        }
    }

    @Override
    public void onClick(View v) {
        if(v==binding.btnHome){
            this.fragmentListener.changePage(1);
        }else if(v==binding.btnPertemuan){
            this.fragmentListener.changePage(2);
        }else if(v==binding.btnDokter){
            this.fragmentListener.changePage(3);
        }else if(v==binding.btnPengaturan){
            this.fragmentListener.changePage(4);
        }else if(v==binding.btnExit){
            this.fragmentListener.closeApplication();
        }
    }
}
