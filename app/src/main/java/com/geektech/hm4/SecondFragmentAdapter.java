package com.geektech.hm4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.hm4.databinding.SecondItemBinding;

import java.util.ArrayList;

public class SecondFragmentAdapter extends RecyclerView.Adapter<SecondFragmentAdapter.ViewHolder2> {

    ArrayList<Integer> list = new ArrayList<>();

    public void addItems(ArrayList<Integer> integers){
        this.list.addAll(integers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder2(SecondItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SecondFragmentAdapter.ViewHolder2 holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private SecondItemBinding binding;

        public ViewHolder2(@NonNull SecondItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Integer integer) {
            binding.tvNum.setText(String.valueOf(getAdapterPosition()+1));
        }
    }
}
