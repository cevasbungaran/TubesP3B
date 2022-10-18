package com.example.tubesdokter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class DaftarDokterAdapter extends BaseAdapter {
    private List<Dokter> listItems;
    private Activity activity;

    public DaftarDokterAdapter(Activity activity){
        this.activity = activity;
        this.listItems = new ArrayList<Dokter>();
    }

    public void updateArray(List<Dokter>arr){
        this.listItems = arr;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.activity.getLayoutInflater().inflate(R.layout.item_list_dokter, parent, false);
        Dokter currentDokter = (Dokter) this.getItem(position);

        return convertView;
    }
}
