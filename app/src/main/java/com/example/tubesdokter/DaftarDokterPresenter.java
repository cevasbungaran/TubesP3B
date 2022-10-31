package com.example.tubesdokter;

import java.util.ArrayList;
import java.util.List;

public class DaftarDokterPresenter {
    interface IMainActivity{
        void updateArray(List<Dokter> arr);
        void resetDaftarDokterForm();
    }

    protected List<Dokter> dokters;
    protected IMainActivity ui;

    public DaftarDokterPresenter(IMainActivity ui){
        this.dokters = new ArrayList<Dokter>();
        this.ui = ui;
    }

    public void add(String nama, String spesialisasi){
        this.dokters.add(new Dokter(nama,spesialisasi));
        this.ui.updateArray(this.dokters);
        this.ui.resetDaftarDokterForm();
    }
}
