package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
/**
 * This class represents a job generator that loads job options from a CSV file.
 * It provides a method to randomly select and retrieve a job from the loaded options.
 *
 * @author Minato Allen
 */
public class Job {
    /**
     * The selected job option.
     */
    String finalJob;
    /**
     * Constructs a new Job object.
     *
     * @param job the initial value of the job
     */
    public Job(String job) {
        this.finalJob = job;
    }
    /**
     * Loads job options from a CSV file and selects a random job.
     *
     * @param context the context of the application
     * @throws IOException if there is an error loading the file
     */
    public void loadJobs(Context context) throws IOException {
        AssetManager asset = context.getAssets();
        // Open the job file from the assets folder
        InputStream is = asset.open("Job.csv");
        Scanner scan = new Scanner(is);
        Random rand = new Random();

        ArrayList<String> jobselector = new ArrayList<>();
        // Populate the ArrayList with job options from the CSV file
        while (scan.hasNextLine()) {
            jobselector.add(scan.nextLine());
        }
        // Randomly select a job from the loaded options
        int jobModVal = rand.nextInt(jobselector.size()-1);

        finalJob = jobselector.get(jobModVal);
        // Clear the ArrayList to release memory
        jobselector.clear();
    }
    /**
     * Gets the selected job.
     *
     * @return the selected job as a string
     */
    public String getJob() {
        return finalJob;
    }
}
