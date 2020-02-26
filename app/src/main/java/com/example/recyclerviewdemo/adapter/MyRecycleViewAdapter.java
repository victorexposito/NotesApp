package com.example.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.storage.NoteStorage;
import com.example.recyclerviewdemo.view.ViewHolder;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<String> list;

    public MyRecycleViewAdapter(ArrayList<String> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ll = (LinearLayout) LayoutInflater.
                from(parent.getContext()).inflate(R.layout.customrow, parent, false);

        return new ViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
       // holder.textView.setText(list.get(position)); //bind data to one row in the view
    }

    @Override
    public int getItemCount() {
        return NoteStorage.getLength();
    }
}
