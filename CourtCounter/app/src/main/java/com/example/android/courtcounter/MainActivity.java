package com.example.android.courtcounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    public int scoreTeamA, scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayScoreTeamA(){
        TextView scoreAText = (TextView)findViewById(R.id.score_team_a);
        scoreAText.setText(String.valueOf(scoreTeamA));
    }

    public void displayScoreTeamB(){
        TextView scoreBText = (TextView)findViewById(R.id.score_team_b);
        scoreBText.setText(String.valueOf(scoreTeamB));
    }


    public void addOneToScoreTeamA(View v){
        scoreTeamA = scoreTeamA + 1;
        displayScoreTeamA();
    }

    public void addOneToScoreTeamB(View v){
        scoreTeamB = scoreTeamB + 1;
        displayScoreTeamB();
    }


    public void addTwoToScoreTeamA(View v){
        scoreTeamA = scoreTeamA + 2;
        displayScoreTeamA();
    }

    public void addTwoToScoreTeamB(View v){
        scoreTeamB = scoreTeamB + 2;
        displayScoreTeamB();
    }

    public void addThreeToScoreTeamA(View v){
        scoreTeamA = scoreTeamA + 3;
        displayScoreTeamA();
    }

    public void addThreeToScoreTeamB(View v){
        scoreTeamB = scoreTeamB + 3;
        displayScoreTeamB();
    }

    public void resetScore(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA();
        displayScoreTeamB();
    }
}
