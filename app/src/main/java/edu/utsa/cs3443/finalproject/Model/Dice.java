package edu.utsa.cs3443.finalproject.Model;


import java.util.ArrayList;
import java.util.Random;
/**
 * This class represents a customizable dice roller.
 * It allows the user to simulate rolling a dice with a specified number of sides and additional weights.
 * The weights can be added to modify the outcome of the roll.
 *
 * @author Alfonso Lopez Aquino
 */
public class Dice {
    private int weights;
    private int currentRoll;
    /**
     * Constructs a new Dice object with default values.
     * The weights and current roll are initialized to zero.
     */

    public Dice() {
        weights = 0;
        currentRoll = 0;
    }
    /**
     * Simulates rolling a nude (unmodified) dice with a specified number of sides.
     *
     * @param sides the number of sides on the dice
     * @return the result of the unmodified dice roll
     */
    private int nudeRoll(int sides) {
        Random rand = new Random();
        return (rand.nextInt(sides) + 1);
    }
    /**
     * Simulates rolling a dice with a specified number of sides and additional weights.
     *
     * @param args an ArrayList of weights to be added to the roll
     * @param sides the number of sides on the dice
     * @return the result of the dice roll after applying weights
     */
    public int roll(ArrayList<Integer> args, int sides) {
        currentRoll = nudeRoll(sides);

        for (Integer x : args) {
            currentRoll += x;
        }
        return currentRoll;
    }
    /**
     * Resets the current roll and weights to zero.
     */
    public void reset() {
        this.currentRoll = 0;
        this.weights = 0;
    }
    /**
     * Returns a string representation of the current roll and weights.
     *
     * @return a string containing the current roll and weights
     */
    public String toString() {
        return "Roll: " + currentRoll + "\nWeights: " + weights;
    }
}
