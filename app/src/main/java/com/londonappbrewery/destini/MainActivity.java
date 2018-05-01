package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mChoice1;
    Button mChoice2;
    TextView mStoryView;
    int mStoryIndex = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mChoice1 = findViewById(R.id.buttonTop);
        mChoice2 = findViewById(R.id.buttonBottom);
        mStoryView = findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextStoryTop();

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               nextStoryBottom();

            }
        });



    }

    private void nextStoryTop(){

        if (mStoryIndex == 1 || mStoryIndex == 2){

            mStoryView.setText(R.string.T3_Story);
            mChoice1.setText(R.string.T3_Ans1);
            mChoice2.setText(R.string.T3_Ans2);
            mStoryIndex = 3;

        }else{

            mStoryView.setText(R.string.T6_End);
            mChoice1.setVisibility(View.GONE);
            mChoice2.setVisibility(View.GONE);
            gameOver();

        }

    }

    private void nextStoryBottom(){

        if(mStoryIndex == 1){

            mStoryView.setText(R.string.T2_Story);
            mChoice1.setText(R.string.T2_Ans1);
            mChoice2.setText(R.string.T2_Ans2);
            mStoryIndex = 2;

        }else if(mStoryIndex == 2){

            mStoryView.setText(R.string.T4_End);
            mChoice1.setVisibility(View.GONE);
            mChoice2.setVisibility(View.GONE);
            gameOver();

        }else{

            mStoryView.setText(R.string.T5_End);
            mChoice1.setVisibility(View.GONE);
            mChoice2.setVisibility(View.GONE);
            gameOver();
        }

    }

    private void gameOver(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game Over");
        alert.setCancelable(false);

        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.show();
        
    }
}
