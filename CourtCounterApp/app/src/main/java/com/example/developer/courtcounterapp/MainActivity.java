package com.example.developer.courtcounterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scorreTeamA = 0;
    int scorreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeForTeamA(View v) {
        scorreTeamA = scorreTeamA + 3;
        displayForTeamA(scorreTeamA);
    }

    public void addTwoForTeamA(View v) {
        scorreTeamA = scorreTeamA + 2;
        displayForTeamA(scorreTeamA);
    }

    public void addOneForTeamA(View v) {
        scorreTeamA = scorreTeamA + 1;
        displayForTeamA(scorreTeamA);
    }

    public void addThreeForTeamB(View v) {
        scorreTeamB = scorreTeamB + 3;
        displayForTeamB(scorreTeamB);
    }

    public void addTwoForTeamB(View v) {
        scorreTeamB = scorreTeamB + 2;
        displayForTeamB(scorreTeamB);
    }

    public void addOneForTeamB(View v) {
        scorreTeamB = scorreTeamB + 1;
        displayForTeamB(scorreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreview = (TextView) findViewById(R.id.team_a_score);
        scoreview.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreview = (TextView) findViewById(R.id.team_b_score);
        scoreview.setText(String.valueOf(score));
    }

    public void resetScore(View v) {
        scorreTeamA = 0;
        scorreTeamB = 0;
        displayForTeamA(scorreTeamA);
        displayForTeamB(scorreTeamB);
    }
}
