package com.example.pblproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pblproject.BinaryQuestionTree;

public class QuestionActivity extends AppCompatActivity {

    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        BinaryQuestionTree bt = new BinaryQuestionTree();
        bt = bt.createBinaryTree();

        question = (TextView) findViewById(R.id.question);
        question.setText("Testing Out");



    }
}
