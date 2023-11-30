package edu.utsa.cs3443.finalproject;
/**
 * The MainActivity class serves as the main entry point for the DND name generator application.
 * It provides buttons to navigate to different activities such as name generation, dice rolling, notes, credits, and exit.
 * All activities start from this MainActivity.
 * This is the group project for Team 10 in CS 3443 Section 003.
 *
 * @author Lillian Ngohuynh
 */
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Buttons for various activities
    Button nameGen;
    Button diceRoll;
    Button notes;
    Button credits;
    Button exit;
    /**
     * Overrides the onCreate method to initialize the main activity.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if not available.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons with their corresponding IDs
         nameGen = findViewById(R.id.name_gen);
         diceRoll = findViewById(R.id.dice_roll);
         notes = findViewById(R.id.notes);
         credits = findViewById(R.id.credits);
         exit = findViewById(R.id.exit);

        nameGen.setOnClickListener(this);
        diceRoll.setOnClickListener(this);
        notes.setOnClickListener(this);
        credits.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    /**
     * Launches the NameActivity when the corresponding button is clicked.
     */
    private void launchNameActivity(){
        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }

    /**
     * Overrides the onClick method to handle button clicks.
     * Starts the corresponding activity based on the clicked button.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.name_gen) {
            launchNameActivity();

        } else if (view.getId() == R.id.dice_roll) {
            Intent intent2 = new Intent(this, DiceActivity.class);
            startActivity(intent2);
        }
        else if (view.getId() == R.id.notes) {
            Intent intent3 = new Intent(this, NotesActivity.class);
            startActivity(intent3);
        }
        else if (view.getId() == R.id.credits) {
            Intent intent4 = new Intent(this, CreditActivity.class);
            startActivity(intent4);
        }
        else if (view.getId() == R.id.exit) {
            finish();
            System.exit(0);
        }
    }
}