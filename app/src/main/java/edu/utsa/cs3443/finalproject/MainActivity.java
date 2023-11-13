package edu.utsa.cs3443.finalproject;
/**
 * @author Lillian ngohuynh
 * @author
 * @author
 * @author
 * This is the MainActivity for the DND name generator. This is the group project for group #10 for CS 3443.
 * All of the activities will start from this MainActivity.
 */
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * Had to include View.OnClickListener interface to override onClick method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * Initialized type Button with their id
 */
        Button nameGen = findViewById(R.id.name_gen);
        Button diceRoll = findViewById(R.id.dice_roll);
        Button notes = findViewById(R.id.notes);
        Button credits = findViewById(R.id.credits);
        Button exit = findViewById(R.id.exit);
/**
 * Ensured that it meant this button and not its parent class
 */

        nameGen.setOnClickListener(this);
        diceRoll.setOnClickListener(this);
        notes.setOnClickListener(this);
        credits.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    /**
     * Starting intents for each Activity
     */
    private void launchNameActivity(){
        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }

    /**
     * Override onClick method and wrote in, that depending on where the user
     * clicks, which button they click, to start that activity. And if they click the exit view
     * to exit the program.
     * @param view
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
//            Intent intent4 = new Intent(this, CreditActivity.class);
//            startActivity(intent4);
        }
        else if (view.getId() == R.id.exit) {
            finish();
            System.exit(0);
        }
    }
}