package com.example.pblproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ResultsActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_quiz:
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_contact:
                    Intent contactI = new Intent(getApplicationContext(), ContactActivity.class);
                    startActivity(contactI);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        String results = getIntent().getStringExtra("results");

        String[] resultsArray = results.split(",");

        ScrollView scrollView = (ScrollView) findViewById(R.id.result_buttons);

// Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_panel);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

// Add Buttons
        for (int i = 0; i < resultsArray.length; i++){
            Button button = new Button(this);
            button.setText(i);
            linearLayout.addView(button);

        }


// Add the LinearLayout element to the ScrollView
        scrollView.addView(linearLayout);


    }
}
