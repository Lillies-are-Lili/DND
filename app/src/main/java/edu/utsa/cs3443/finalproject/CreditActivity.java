package edu.utsa.cs3443.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/**
 * The CreditActivity class represents the activity displaying credits or acknowledgments in the application.
 * It extends the AppCompatActivity class and is associated with the "activity_credit" layout.
 * This activity is typically used to acknowledge contributors or provide credits for the application.
 *
 * @author lillianngo
 */
public class CreditActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     * This method sets the content view to the layout specified in "activity_credit.xml" during activity creation.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, or null if not available.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
    }
}