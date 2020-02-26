package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.recyclerviewdemo.adapter.MyRecycleViewAdapter;
import com.example.recyclerviewdemo.storage.FileHandler;
import com.example.recyclerviewdemo.storage.NoteStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteStorage.setFileHandler(new FileHandler(this));
        recyclerView = findViewById(R.id.recyclerview1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(getList());
        recyclerView.setAdapter(adapter);
        //recyclerView.setAdapter(new MyRecycleViewAdapter(getList()));
    }

    @Override
    protected void onResume(){
        super.onResume();
        NoteStorage.readNotesFromFile();
        adapter.notifyDataSetChanged(); // will make list update itself
    }

    @Override
    protected void onPause(){
        super.onPause();
        NoteStorage.saveNotesToFile();
    }

    private ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("the quick brown fox");
        list.add("jumped over the lazy dog");
        list.add("again and again");
        list.add("again and again");
        list.add("again and again");
        return list;
    }







}
