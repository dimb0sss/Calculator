package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int max = 50;
    int min = 5;
    boolean isPositive;
    private int rightAnswer;
    private String question;
    private TextView textViewQuestion;
    private TextView textViewAnswer;
    private EditText editText;
    private Button buttonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewAnswer = findViewById(R.id.textViewAnswer);
        editText = findViewById(R.id.editTextAnswer);
        buttonAnswer = findViewById(R.id.button);
        startGame();
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = editText.getText().toString().trim();
                textViewAnswer.setText("");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (answer.equals(String.valueOf(rightAnswer))) {
                    textViewAnswer.setBackgroundColor(Color.parseColor("#00ff00"));
                    textViewAnswer.setText("CORRECT!!!");
                } else {
                    textViewAnswer.setText("INCORRECT!!!");
                    textViewAnswer.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                editText.setText("");
                startGame();
            }
        });

    }



    public void startGame() {
        int a = (int) (Math.random()*(max-min+1)+min);
        int b = (int) (Math.random()*(max-min+1)+min);
        int mark = (int) (Math.random()*2);
        isPositive = mark==1;
        if (isPositive) {
            rightAnswer = a + b;
            question = String.format("%s + %s = ?",a,b);
        } else  {
            rightAnswer = a - b;
            question = String.format("%s - %s = ?",a,b);
        }
        textViewQuestion.setText(question);
    }

}