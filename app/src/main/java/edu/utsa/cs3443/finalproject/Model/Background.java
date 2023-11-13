package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Background {
    String finalBack;


    public Background(String finalBack) {
        this.finalBack = finalBack;
    }
    public void loadBackground(Context context) throws IOException {
        AssetManager asset = context.getAssets();

        try {
            InputStream is = asset.open("background.csv");
            Scanner scan = new Scanner(is);
            Random rand = new Random();

            ArrayList<String> temp = new ArrayList<>();
            while(scan.hasNextLine()) {
                temp.add(scan.nextLine());
            }
            finalBack = temp.get(rand.nextInt(temp.size()-1));

        } catch(IOException e) {
            System.out.println("Failed background IO");
        }
    }


    public String getBack() {
        return finalBack;
    }
}
