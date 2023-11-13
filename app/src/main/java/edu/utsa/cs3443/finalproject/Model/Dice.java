package edu.utsa.cs3443.finalproject.Model;


import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private int weights;
    private int currentRoll;

    public Dice() {
        weights = 0;
        currentRoll = 0;
    }

    private int nudeRoll(int sides) {
        Random rand = new Random();
        return (rand.nextInt(sides) + 1);
    }

    public int roll(ArrayList<Integer> args, int sides) {
        currentRoll = nudeRoll(sides);

        for (int x : args) {
            currentRoll += x;
        }
        return currentRoll;
    }

    public void reset() {
        this.currentRoll = 0;
        this.weights = 0;
    }
}
