package com.example.pblproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pblproject.BinaryQuestionTree;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private BinaryQuestionTree bt = BinaryQuestionTree.createBinaryTree();
    String results;

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
        setContentView(R.layout.activity_question);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button yes = (Button) findViewById(R.id.yesButton);
        yes.setOnClickListener(this);
        Button no = (Button) findViewById(R.id.noButton);
        no.setOnClickListener(this);








    }

    @Override
    public void onClick(View view) {
        question = (TextView) findViewById(R.id.question);


        switch (view.getId()){
            case R.id.yesButton:

                if(bt.question1.left.left == null){
                    System.out.println("here");
                    Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                    intent.putExtra("results", bt.question1.left.data);
                    startActivity(intent);

                }
                else {
                    bt.question1 = bt.question1.left;
                    question.setText(bt.question1.data);
                }

                break;
            case R.id.noButton:
                if(bt.question1.right.left == null){
                    System.out.println("here");
                    Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                    intent.putExtra("results", bt.question1.right.data);
                    startActivity(intent);

                }
                else {
                    bt.question1 = bt.question1.right;

                    question.setText(bt.question1.data);
                }

                break;
        }

    }
}
