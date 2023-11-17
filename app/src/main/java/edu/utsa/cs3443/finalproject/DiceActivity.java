package edu.utsa.cs3443.finalproject;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.finalproject.Model.Dice;

import java.util.ArrayList;

public class DiceActivity extends AppCompatActivity {

    private Spinner diceSelectSpinner;
    private Spinner levelDropDownSpinner;
    private ToggleButton proficiencyToggle;
    private Spinner advantageSpinner;
    private Button rollButton;
    private TextView resultDisplay;
    //private Button backButton;
    private ArrayList<Integer> history = new ArrayList<>();

    private TableLayout tableLayout;

    private ArrayList<Integer> args = new ArrayList<>();
    private final Dice choice = new Dice();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        // Initialize UI components
        diceSelectSpinner = findViewById(R.id.Dice_Select);
        levelDropDownSpinner = findViewById(R.id.Level_DropDown);
        proficiencyToggle = findViewById(R.id.Prof_Toggle);
        advantageSpinner = findViewById(R.id.Advantage_Spinner);
        rollButton = findViewById(R.id.Roll);
        resultDisplay = findViewById(R.id.Result_Display);
        tableLayout = findViewById(R.id.roll_table);

        // Set up Spinners
        ArrayAdapter<CharSequence> diceAdapter = ArrayAdapter.createFromResource(this,
                R.array.dice_array, android.R.layout.simple_spinner_item);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceSelectSpinner.setAdapter(diceAdapter);

        ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(this,
                R.array.level_array, android.R.layout.simple_spinner_item);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelDropDownSpinner.setAdapter(levelAdapter);

        ArrayAdapter<CharSequence> advantageAdapter = ArrayAdapter.createFromResource(this,
                R.array.advantage_array, android.R.layout.simple_spinner_item);
        advantageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        advantageSpinner.setAdapter(advantageAdapter);


        // Set up button click listeners
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(diceSelect() != 0) {
                    if (proficiencyToggle.isChecked() && !"Select Level".equals(levelDropDownSpinner.getSelectedItem().toString())) {
                        args = argBuilder();
                        String temp;
                        if (advantageSpinner.getSelectedItem().toString() == "Advantage") {
                            int roll1 = choice.roll(args, diceSelect());
                            int roll2 = choice.roll(args, diceSelect());
                            if (roll1 >= roll2) {
                                temp = Integer.toString(roll1);
                            } else {
                                temp = Integer.toString(roll2);
                            }
                        } else if (advantageSpinner.getSelectedItem().toString() == "Disadvantage") {
                            int roll1 = choice.roll(args, diceSelect());
                            int roll2 = choice.roll(args, diceSelect());
                            if (roll1 >= roll2) {
                                temp = Integer.toString(roll2);
                            } else {
                                temp = Integer.toString(roll1);
                            }
                        } else {
                            temp = Integer.toString(choice.roll(args, diceSelect()));
                        }
                        resultDisplay.setText(temp);
                        addRoll(Integer.valueOf(temp));
                        choice.reset();
                        args.clear();
                    } else {
                        Toast.makeText(DiceActivity.this, "Please select a level for proficiency bonus!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DiceActivity.this, "Please select a Dice!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /**
     * Adds a new roll to the history, ensuring the history list contains no more than 12 elements.
     * If adding the new roll would exceed the size limit, the oldest element is removed.
     *
     * @param roll The roll value to be added to the history.
     */
    private void historyControl(Integer roll) {
        try {
            this.history.add(roll);

            while(this.history.size() > 12) {
                this.history.remove(0);
            }
        } catch (NullPointerException e) {
            System.out.println("History Control ArrayList Null exception");
        }
    }
    private void updateTable() {
        tableLayout.removeAllViews();
        for (int i = 0; i < history.size(); i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setText(String.valueOf(history.get(i)));
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setPadding(5, 5, 5, 5);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(20);

            row.addView(textView);
            tableLayout.addView(row);
        }
    }


    private void addRoll(int roll) {
        historyControl(roll); // Your method to control history size
        updateTable(); // Update table with new history
    }

    private int diceSelect() {
        String select = diceSelectSpinner.getSelectedItem().toString();
        int toReturn = 0;
        switch (select) {
            case ("D3"):
                toReturn = 3;
                break;
            case ("D4"):
                toReturn = 4;
                break;
            case ("D6"):
                toReturn = 6;
                break;
            case ("D8"):
                toReturn = 8;
                break;
            case ("D10"):
                toReturn = 10;
                break;
            case ("D12"):
                toReturn = 12;
                break;
            case ("D20"):
                toReturn = 20;
                break;
            default:
                System.out.println("ERROR DICE SWITCH");
                break;
        }
        return toReturn;
    }

    private ArrayList<Integer> argBuilder() {
        ArrayList<Integer> toReturn = new ArrayList<>();
        if (proficiencyToggle.isChecked()) {
            int temp = Integer.valueOf(levelDropDownSpinner.getSelectedItem().toString());
            if (temp < 5) {
                toReturn.add(2);
            } else if (temp < 9) {
                toReturn.add(3);
            } else if (temp < 13) {
                toReturn.add(4);
            } else if (temp < 17) {
                toReturn.add(5);
            } else {
                toReturn.add(6);
            }
    }
        return toReturn;
    }
}
