package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;


public class CharacterName {

    private String finalString;
    private ArrayList<String> first = new ArrayList<>();
    private ArrayList<String> last = new ArrayList<>();

    public CharacterName(String finalString) {
        this.finalString = finalString;
    }
    public void loadCharacter(Context context) throws IOException {

        try {
            AssetManager asset = context.getAssets();

            InputStream is = asset.open("firstname.csv");
            InputStream is2 = asset.open("lastname.csv");
            Scanner scan = new Scanner(is);
            Scanner scan2 = new Scanner(is2);
            //int randFinal, randFinal2;
            //Random rand = new Random();

            //randFinal = rand.nextInt(100);
            //randFinal2 = rand.nextInt(100);
            //int randFinal = new Random().nextInt(100);
            //int randFinal2 = new Random().nextInt(100);
            Toast.makeText(context, "yay", Toast.LENGTH_SHORT).show();

            while (scan.hasNextLine()) {
                first.add(scan.nextLine());
            }
            while (scan2.hasNextLine()) {
                last.add(scan2.nextLine());
            }
            Random gen = new Random();
            int ran1 = gen.nextInt(first.size()-1);
            int ran2 = gen.nextInt(last.size()-1);
            String firstName = first.get(ran1);
            String lastName = last.get(ran2);

            finalString = firstName + " " + lastName;
            first.clear();
            last.clear();
        } catch(IOException e) {
            System.out.println("EEEE");
        }
    }

    public String getName() {
        return finalString;
    }
}
