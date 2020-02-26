package com.example.recyclerviewdemo.view;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.DetailActivity;
import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.model.Note;
import com.example.recyclerviewdemo.storage.NoteStorage;



public class ViewHolder extends RecyclerView.ViewHolder {

    public NoteStorage ns;
    public TextView textView;
    public ImageView imageView;
    public static final String rowKey = "ROW_KEY";
    public Button button;
    public int rowNumber = -1; // number, which corresponds to the items position in the list
    public ViewHolder(@NonNull final View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        textView = linearLayout.findViewById(R.id.textView1);
        imageView = linearLayout.findViewById(R.id.imageView);



        button = linearLayout.findViewById(R.id.button);
        button.setBackgroundColor(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NoteStorage.getNote(rowNumber).toogleLike();
                if(NoteStorage.getNote(rowNumber).getLiked()){
                    button.setText("Liked");
                    button.setBackgroundColor(Color.CYAN);
                }else{
                    button.setText("Like");
                    button.setBackgroundColor(R.id.button);
                }
            }
        });
        setTextViewListener();
    }

    private void setTextViewListener(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(rowKey, rowNumber);
                v.getContext().startActivity(intent);
            }
        });
    }
    public void setData(int row){
        rowNumber = row;
        textView.setText(NoteStorage.getNote(rowNumber).headline);
        imageView.setImageResource(getImageId());
        //textView.setText(list.get(row)); //bind data to one row in the view
    }

    private int getImageId(){
        switch (rowNumber){
            case 0: return R.drawable.image0;
            case 1: return R.drawable.image1;
            case 2: return R.drawable.image2;
            case 3: return R.drawable.image3;
            case 4: return R.drawable.image4;
            case 5: return R.drawable.image5;
            case 6: return R.drawable.image6;
            case 7: return R.drawable.image7;
            case 8: return R.drawable.image8;
            case 9: return R.drawable.image9;
        }
        return R.drawable.image0;
    }

}
