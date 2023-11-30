package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
/**
 * This class represents the background for the game.
 * It is responsible for loading the background from the assets folder.
 * The background is determined randomly from a list of available backgrounds.
 *
 * @author Minato Allen
 */

public class Background {
    /**
     * The path to the background file.
     */
    String finalBack;
    /**
     * Constructs a new Background object.
     * @param finalBack the path to the background file
     */
    public Background(String finalBack) {
        this.finalBack = finalBack;
    }
    /**
     * Loads the background from the assets folder.
     * @param context the context of the application
     * @throws IOException if there is an error loading the file
     */
    public void loadBackground(Context context) throws IOException {
        AssetManager asset = context.getAssets();
        // Open the background file from the assets folder
        try {
            InputStream is = asset.open("Background.csv");
            // Read the file using a Scanner
            Scanner scan = new Scanner(is);
            Random rand = new Random();
            // Store each line of the file in an ArrayList
            ArrayList<String> temp = new ArrayList<>();
            while(scan.hasNextLine()) {
                temp.add(scan.nextLine());
            }
            // Randomly select a background from the list
            finalBack = temp.get(rand.nextInt(temp.size()-1));
            // Handle IO exception
        } catch(IOException e) {
            System.out.println("Failed background IO");
        }
    }
    /**
     * Gets the path to the background.
     * @return the string finalBack representing the path to the background file
     */
    public String getBack() {
        return finalBack;
    }
}
