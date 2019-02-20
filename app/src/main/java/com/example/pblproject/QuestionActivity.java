package com.example.pblproject;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pblproject.BinaryQuestionTree;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        BinaryQuestionTree bt = new BinaryQuestionTree();
        bt = bt.createBinaryTree();
        Button yes = (Button) findViewById(R.id.yesButton);
        yes.setOnClickListener(this);
        Button no = (Button) findViewById(R.id.noButton);
        no.setOnClickListener(this);
        question = (TextView) findViewById(R.id.question);
        question.setText(bt.question1.data);








    }

    @Override
    public void onClick(View view) {
        BinaryQuestionTree bt = new BinaryQuestionTree();
        bt = bt.createBinaryTree();
        question = (TextView) findViewById(R.id.question);


        switch (view.getId()){
            case R.id.yesButton:
                bt.question1 = bt.question1.left;
                question.setText(bt.question1.data);
                break;
            case R.id.noButton:
                bt.question1 = bt.question1.right;
                question.setText(bt.question1.data);
                break;
        }

    }
}
