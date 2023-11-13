package edu.utsa.cs3443.finalproject.Model;

import android.content.Context;
import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

public class Job {
    String finalJob;

    public Job(String job) {
        this.finalJob = job;
    }

    public void loadJobs(Context context) throws IOException {
        AssetManager asset = context.getAssets();

        InputStream is = asset.open("Job.csv");
        Scanner scan = new Scanner(is);
        Random rand = new Random();

        ArrayList<String> jobselector = new ArrayList<>();
        //bound is currently hardcoded as 5 since there are only 5 lines within the csv
        while (scan.hasNextLine()) {
            jobselector.add(scan.nextLine());
        }
        int jobModVal = rand.nextInt(jobselector.size()-1);

        finalJob = jobselector.get(jobModVal);
        jobselector.clear();
    }

    public String getJob() {
        return finalJob;
    }
}
