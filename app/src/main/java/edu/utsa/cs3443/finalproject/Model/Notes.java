package edu.utsa.cs3443.finalproject.Model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import android.app.Activity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Notes class manages the creation, loading, and manipulation of notes.
 */
public class Notes {
    private String note;
    private Activity activity;
    private File[] listOfFiles ;

    /**
     * Constructor for the Notes class.
     *
     * @param activity The activity associated with the Notes instance.
     */
    public Notes(Activity activity) {
        this.activity = activity;
    }

    /**
     * Load notes from the notes directory.
     */
    public void loadNotes() {
        File directory = new File(activity.getApplicationContext().getFilesDir().toString() + "/notes");
        if(directory.exists()){
            listOfFiles = directory.listFiles();
        }else{
            directory.mkdir();
        }
    }

    /**
     * Get the names of all available notes.
     *
     * @return An ArrayList containing the names of all notes.
     */
    public ArrayList<String> getnames() {
        ArrayList<String> str = new ArrayList<>();
        if(listOfFiles != null){
            for(File file : listOfFiles){
                str.add(file.getName());
            }
        }
        return str;
    }

    /**
     * Get the content of a specific note.
     *
     * @param indexOf The index of the note in the list of files.
     * @return The content of the specified note.
     */
    public String getText(int indexOf) {
        String str = "";
        try {
            FileReader reader = new FileReader(listOfFiles[indexOf]);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                str = str + line;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    /**
     * Create or update a note with the specified title and content.
     *
     * @param ttl  The title of the note.
     * @param text The content of the note.
     */
    public void setfile(String ttl, String text) {
        File temp = new File(activity.getApplicationContext().getFilesDir().toString() + "/notes/" + ttl);
        FileWriter writer = null;
        if(!temp.exists()){
            try {
                temp.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer = new FileWriter(temp);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete the specified note.
     *
     * @param indexOf The index of the note in the list of files.
     */
    public void smiteFile(int indexOf) {
        listOfFiles[indexOf].delete();
    }
}

