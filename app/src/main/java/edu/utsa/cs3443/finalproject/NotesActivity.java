package edu.utsa.cs3443.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import edu.utsa.cs3443.finalproject.Model.Notes;

/**
 * The main activity for the Notes application.
 * Allows users to manage notes, including creating, viewing, updating, and deleting notes.
 * This activity provides a user interface with text fields for note title and body, a spinner for selecting existing notes,
 * and buttons for actions such as creating a new note, viewing/editing a selected note, and deleting a selected note.
 * Uses the Notes class to manage the creation, loading, and manipulation of notes.
 *
 * @author Mackenzie Tully
 */


public class NotesActivity extends AppCompatActivity implements View.OnClickListener{
    // UI elements
    private EditText body;
    private EditText tile;
    private Spinner spinner;

    // Notes instance to manage notes
    Notes notes;

    // List to store note names
    ArrayList<String> noteNames;

    /**
     * Overrides the onCreate method to initialize the NotesActivity.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if not available.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        // Initialize UI elements
        spinner = findViewById(R.id.spinner);
        body = findViewById(R.id.Body);
        tile = findViewById(R.id.Title);

        // Set default values for body and tile
        body.setText("DEFAULT");
        tile.setText("DEFAULT");

        // Initialize Notes instance and load existing notes
        notes = new Notes(this);
        notes.loadNotes();
        noteNames = notes.getnames();

        // Set up the spinner with note names
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom, noteNames.toArray());
        spinner.setAdapter(adapter);

        // Set up click listeners for buttons
        setupButton(R.id.Push);
        setupButton(R.id.Pull);
        setupButton(R.id.Destroy);


    }

    /**
     * Overrides the onClick method to handle button clicks.
     * Performs actions based on the clicked button.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Pull) {
            // Handle Pull button click
            if (noteNames.isEmpty()) {
                Toast.makeText(this, "YOU HAVE NO MORE FILES TO PULL", Toast.LENGTH_SHORT).show();
            } else {
                // Set text fields with selected note content
                tile.setText(spinner.getSelectedItem().toString());
                body.setText(notes.getText(noteNames.indexOf(spinner.getSelectedItem().toString())));
//                Toast.makeText(this, "Hurrah", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.Push) {
            // Handle Push button click
            String ttl = String.valueOf(tile.getText());
            String text = String.valueOf(body.getText());
            notes.setfile(ttl, text);
            notes.loadNotes();
            noteNames = notes.getnames();
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom, noteNames.toArray());
            spinner.setAdapter(adapter);
        } else if (view.getId() == R.id.Destroy) {
            // Handle Destroy button click
            if (noteNames.isEmpty()) {
                Toast.makeText(this, "YOU HAVE NO MORE FILES TO SMITE", Toast.LENGTH_SHORT).show();
            } else {
                // Remove the selected note and update the UI
                notes.smiteFile(noteNames.indexOf(spinner.getSelectedItem().toString()));
                notes.loadNotes();
                noteNames = notes.getnames();
                ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom, noteNames.toArray());
                spinner.setAdapter(adapter);
            }
        }
    }

    /**
     * Set up click listener for a button.
     *
     * @param ButtonID The resource ID of the button.
     */
    private void setupButton(int ButtonID) {
        Button button = findViewById(ButtonID);
        button.setOnClickListener(this);
    }
}