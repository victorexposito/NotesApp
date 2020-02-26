package com.example.recyclerviewdemo.storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

    private Context context;


    public FileHandler(Context context) {
        this.context = context;
    }

    public void saveToFile(Object obj, String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(getFileObject(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            Log.i("all", "OK");
        } catch (Exception e) {
            Log.i("all", "error writing" + e.getMessage());
        }
    }

    public Object readFile(String fileName){
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(getFileObject(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
            Log.i("all", "OK");

        } catch (Exception e){
            Log.i("all", "error reading" + e.getMessage());
        }
        return obj;
    }

    private File getFileObject(String fileName){
        File path = context.getFilesDir();
        return new File(path, "text.dat");



    }


}