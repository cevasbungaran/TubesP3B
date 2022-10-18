package com.example.tubesdokter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tubesdokter.databinding.ActivityMainBinding;
import com.example.tubesdokter.databinding.FragmentDaftarDokterBinding;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private ActivityMainBinding binding;
    protected MainFragment mainFragment;
    protected PertemuanFragment pertemuanFragment;
    protected TambahDokterFragment tambahDokterFragment;
    protected DaftarDokterFragment daftarDokterFragment;
    protected FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private DaftarDokterAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        
        //adapter
        this.adapter = new DaftarDokterAdapter (this);

        
        
        //fragment
        this.mainFragment = MainFragment.newInstance();
        this.pertemuanFragment = PertemuanFragment.newInstance();
        this.tambahDokterFragment = TambahDokterFragment.newInstance();
        this.daftarDokterFragment = DaftarDokterFragment.newInstance();

        this.fragmentManager = this.getSupportFragmentManager();
        ft = this.fragmentManager.beginTransaction();
        ft.add(binding.fragmentContainer.getId(), this.mainFragment).addToBackStack(null).commit();
        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(abdt);
        abdt.syncState();
    }

    @Override
    public void changePage(int page) {
        ft = this.fragmentManager.beginTransaction();

        if (page == 1) {
            Log.d("debug", "changePage: page1");
            ft.replace(R.id.fragment_container,this.mainFragment).addToBackStack(null);
        } else if (page == 2) {
            ft.replace(R.id.fragment_container,this.pertemuanFragment).addToBackStack(null);
        } else if (page == 3) {
            ft.replace(R.id.fragment_container,this.daftarDokterFragment).addToBackStack(null);
        } else if (page == 5) {
            ft.replace(R.id.fragment_container,this.tambahDokterFragment).addToBackStack(null);
        }
        this.ft.commit();
        binding.drawerLayout.closeDrawers();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}