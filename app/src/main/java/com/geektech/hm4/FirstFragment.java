package com.geektech.hm4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.hm4.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

   private FragmentFirstBinding binding;
   private FirstFragmentAdapter adapter;
   private ArrayList<FirstFragmentModel> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        adapter = new FirstFragmentAdapter();
        adapter.addItems(list);
        binding.recylerFirst.setAdapter(adapter);
    }

    private void createList(){
        for (int i = 0; i < 20; i++) {
            list.add(new FirstFragmentModel("Name","Surname"));
        }
        list.add(new FirstFragmentModel("End","End"));
    }
}