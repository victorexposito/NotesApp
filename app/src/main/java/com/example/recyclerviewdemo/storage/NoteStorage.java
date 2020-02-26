package com.example.recyclerviewdemo.storage;

import com.example.recyclerviewdemo.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteStorage {
    private static List<Note> list;
    private static final String fileName = "data.dat";
    private  static FileHandler fileHandler;

    static {
        list = new ArrayList<>();
        Note note = new Note("Note 1", "Body 1");
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
        list.add(note);
    }
    public static Note getNote(int index){
        return list.get(index);
    }
    public static void setFileHandler(FileHandler fh){
        fileHandler = fh;
    }
    public static void saveNotesToFile(){
        fileHandler.saveToFile(list, fileName);
    }
    public static void readNotesFromFile(){
        Object object = fileHandler.readFile(fileName);
        if(object != null){
            list = (List<Note>)object;
        }
    }

    public static int getLength(){
        return list.size();
    }
}
