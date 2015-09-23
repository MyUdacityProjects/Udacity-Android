package com.example.android.gitcommitmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by harshita.k on 23/09/15.
 */
public class TipsActivity extends AppCompatActivity  {

    int tipIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }

    public void viewNextTip(View v){
        if(tipIndex == 5){
            submitFeedback();
        }else{
            tipIndex = tipIndex + 1;
            displayTipIndex();

        }

    }

    public void viewPrevTip(View v){
        if(tipIndex == 1){
            // Show Toast Message
        }else{
            tipIndex = tipIndex - 1;
            Button nextBtn = (Button) findViewById(R.id.prev_tip);
            displayTipIndex();
        }
    }

    public void displayTipIndex(){
        TextView tipIndexTextView = (TextView) findViewById(R.id.tip_index);
        tipIndexTextView.setText("Tip #"+tipIndex);

        TextView tipHeaderTextView  = (TextView) findViewById(R.id.tip_header);
        TextView tipMessageTextView  = (TextView) findViewById(R.id.tip_msg);

        String tipHeaderId = "tip_"+tipIndex+"_header";
        String tipMsgId = "tip_"+tipIndex+"_msg";
        int tipMsgResourceID = this.getResources().getIdentifier(tipMsgId,"string", this.getApplicationInfo().packageName);
        int tipHeaderResourceID = this.getResources().getIdentifier(tipHeaderId,"string", this.getApplicationInfo().packageName);
        if (tipMsgResourceID != 0 && tipHeaderResourceID != 0) {
            tipHeaderTextView.setText(tipHeaderResourceID);
            tipMessageTextView.setText(tipMsgResourceID);
        }
    }

    public void submitFeedback(){
        Intent intent = new Intent(TipsActivity.this, FeedbackActivity.class);
        startActivity(intent);
    }
}
