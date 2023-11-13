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
public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    TextView text;
    CharacterName cn = new CharacterName("");
    Background back = new Background("");
    Job job = new Job("");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        spinner = findViewById(R.id.spinner);
        text = findViewById(R.id.finalText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.raceGeneration));
        spinner.setAdapter(adapter);

        setupButton(R.id.jobGeneration);
        setupButton(R.id.backGenerate);
        setupButton(R.id.generate);


    }

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

    public void setupButton(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }

    public String getName() {
        return cn.getName();
    }

    public String getJob() {
        return job.getJob();
    }

    public String getBack() {
        return back.getBack();
    }

}
