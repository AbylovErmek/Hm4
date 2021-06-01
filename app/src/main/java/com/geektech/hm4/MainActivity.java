package com.geektech.hm4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.geektech.hm4.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter adapter;
    String [] titles = {"TITLES","NUMBERS","IMAGES"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager2 = binding.viewPager;
        adapter = new ViewPagerAdapter(this);
        adapter.addItem(new FirstFragment());
        adapter.addItem(new SecondFragment());
        adapter.addItem(new ThirdFragment());
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(binding.tab,viewPager2, (new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles[position]);
            }
        })).attach();
    }
}