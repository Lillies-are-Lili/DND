package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a character's name generator.
 * It provides methods to load lists of first and last names from files and generate random character names.
 *
 * @author Minato Allen
 */
public class CharacterName {

    private String finalString;
    private ArrayList<String> first = new ArrayList<>();
    private ArrayList<String> last = new ArrayList<>();
    /**
     * Constructs a new CharacterName object.
     * @param finalString the initial value of the character's name
     */

    public CharacterName(String finalString) {
        this.finalString = finalString;
    }
    /**
     * Loads lists of first and last names from CSV files.
     *
     * @param context the context of the application
     * @throws IOException if there is an error loading the files
     */
    public void loadList(Context context) throws IOException {
        try {
        AssetManager asset = context.getAssets();
            // Open files for first and last names
        InputStream is = asset.open("firstname.csv");
        InputStream is2 = asset.open("lastname.csv");
        Scanner scan = new Scanner(is);
        Scanner scan2 = new Scanner(is2);
        // Populate ArrayLists with names
        while (scan.hasNextLine()) {
            first.add(scan.nextLine());
        }
        while (scan2.hasNextLine()) {
            last.add(scan2.nextLine());
        }
            // Handle IO exception
    } catch(IOException e) {
        System.out.println("Failed Character name IO.");
    }
    }
    /**
     * Generates a random character name by combining a random first and last name from the loaded lists.
     *
     * @param context the context of the application
     * @throws IOException if there is an error loading the files
     */
    public void loadCharacter(Context context) throws IOException {

            Random gen = new Random();
            int ran1 = gen.nextInt(first.size()-1);
            int ran2 = gen.nextInt(last.size()-1);
            String firstName = first.get(ran1);
            String lastName = last.get(ran2);
            // Combine first and last names to form the character's name
            finalString = firstName + " " + lastName;

    }
    /**
     * Gets the generated character name.
     *
     * @return the generated character name as a string
     */
    public String getName() {
        return finalString;
    }
}
