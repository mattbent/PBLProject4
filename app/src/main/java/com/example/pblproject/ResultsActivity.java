package com.example.pblproject;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener{
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
        System.out.println(results);

        String[] resultsArray = results.split(",");

        ScrollView scrollView = (ScrollView) findViewById(R.id.result_buttons);

// Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_panel);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

// Add Buttons
        for (int i = 0; i < resultsArray.length; i++){
            Button button = new Button(this);
            button.setText(resultsArray[i]);
            button.setId(i);
            linearLayout.addView(button);
            button.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        Button b = (Button) view;
        String buttonText = b.getText().toString();
        buttonText = buttonText.replaceAll("[&()]", "");
        buttonText = buttonText.replaceAll("\\s", " ");
        buttonText = buttonText.replaceAll(" ", "-");
        buttonText = buttonText.toLowerCase();

        Uri uri = Uri.parse("https://www.fbla-pbl.org/competitive-event/" + buttonText + "/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}


