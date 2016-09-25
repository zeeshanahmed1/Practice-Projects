package com.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    public static int correct;
    int flag = 0;
    boolean cond = false;
    private TextView questionView;
    private Button nextButton;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1, mRadioButton2, mRadioButton3;
    private String[] questions = {"What is the abbrevation of HTML?", "Name of the Latest Android Version", "Who is the CEO of Facebook?","What is the sum of (2.5+1.5)?"};
    public static String[] answers = {"Hyper Text Markup Language", "Marshmellow", "MArck ZuckeBerg","4"};
    private String[] options = {"Hyper Text Makeup Language", "Hyper Text Markup Language", "Hyper Text Language", "Jelly Bean", "Marshmellow", "Lolipop", "MArck ZuckeBerg", "Newton", "Bill Gates","5" ,"4", "6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionView = (TextView) findViewById(R.id.questions_textView);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroupView);
        mRadioButton1 = (RadioButton) findViewById(R.id.rd1);
        mRadioButton2 = (RadioButton) findViewById(R.id.rd2);
        mRadioButton3 = (RadioButton) findViewById(R.id.rd3);
        nextButton = (Button) findViewById(R.id.next_button);

        questionView.setText(questions[flag]);
        mRadioButton1.setText(options[0]);
        mRadioButton2.setText(options[1]);
        mRadioButton3.setText(options[2]);

        buttonClick();


    }

    public void buttonClick() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton youAnswer = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
                String answerText = youAnswer.getText().toString();

                if (answerText.equalsIgnoreCase(answers[flag])) {
                    correct++;


                } else {

                }
                flag++;

                if (flag < questions.length) {
                    //GETTING THE remaining questions
                    questionView.setText(questions[flag]);
                    //getting the remaining questions options
                   mRadioButton1.setText(options[flag * 3]);
                   mRadioButton2.setText(options[(flag * 3) + 1]);
                    mRadioButton3.setText(options[(flag * 3) + 2]);

                } else {
                    Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
