package edu.utsa.cs3443.finalproject;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import edu.utsa.cs3443.finalproject.Model.Background;
import edu.utsa.cs3443.finalproject.Model.CharacterName;
import edu.utsa.cs3443.finalproject.Model.Job;
/**
 * The NameActivity class represents the activity for generating character names, backgrounds, and jobs.
 * It allows users to select a race from a spinner and generate corresponding character information.
 * The activity uses instances of CharacterName, Background, and Job classes for name, background, and job generation.
 * This activity is part of the DND name generator application.
 *
 * @author Minato Allen
 * @author Alfonso Lopez Aquino
 */
public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    TextView text;
    CharacterName cn = new CharacterName("");
    Background back = new Background("");
    Job job = new Job("");

    /**
     * Overrides the onCreate method to initialize the NameActivity.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if not available.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

            // Initialize UI components
        spinner = findViewById(R.id.spinner);
        text = findViewById(R.id.finalText);

        // Set up spinner with array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.raceGeneration));
        spinner.setAdapter(adapter);

        // Set up buttons with click listeners
        setupButton(R.id.jobGeneration);
        setupButton(R.id.backGenerate);
        setupButton(R.id.generate);

        // Load character name list
        try {
            cn.loadList(this);
        } catch(IOException e) {
            System.out.println("Failed to load files");
        } catch(NullPointerException a) {
            System.out.println("Null issue");
        }


    }

    /**
     * Overrides the onClick method to handle button clicks.
     * Generates character information based on the selected button.
     *
     * @param view The view that was clicked.
     */
    public void onClick(View view) {
        text.setText("");
        //boolean arguments here for the switches
        //spinner.getSelectedItem().toString(); ->returns the value that the spinner is currently selected as a string
        if(view.getId() == R.id.generate) {
            try {
                cn.loadCharacter(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text.setText(getName() + ", " + spinner.getSelectedItem().toString());
        }
        else if(view.getId() == R.id.backGenerate){
            try {
                back.loadBackground(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException n) {
                System.out.println("Failed.\n");
            }
            text.setText(getBack());
        }
        else if(view.getId() == R.id.jobGeneration) {
            try {
                job.loadJobs(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException n) {
                System.out.println("Failed.\n");
            }
            text.setText(getJob());
        }
    }

    /**
     * Sets up a button with the given ID and attaches a click listener to it.
     *
     * @param buttonId The ID of the button to be set up.
     */
    public void setupButton(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }

    /**
     * Gets the generated character name.
     *
     * @return The generated character name as a string.
     */
    public String getName() {
        return cn.getName();
    }

    /**
     * Gets the generated job.
     *
     * @return The generated job as a string.
     */
    public String getJob() {
        return job.getJob();
    }

    /**
     * Gets the generated background.
     *
     * @return The generated background as a string.
     */
    public String getBack() {
        return back.getBack();
    }

}
