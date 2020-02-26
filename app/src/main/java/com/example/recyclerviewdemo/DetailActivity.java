package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.recyclerviewdemo.storage.NoteStorage;
import com.example.recyclerviewdemo.view.ViewHolder;

public class DetailActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private int row = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int row = getIntent().getIntExtra(ViewHolder.rowKey, 0);
        textView = findViewById(R.id.headlineTextView);
        editText = findViewById(R.id.detailText);
        textView.setText(NoteStorage.getNote(row).headline);
        editText.setText(NoteStorage.getNote(row).body);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NoteStorage.getNote(row).headline = textView.getText().toString();
        NoteStorage.getNote(row).body = editText.getText().toString();
    }
}
