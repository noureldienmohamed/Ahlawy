package com.example.nour.ahlawy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends Activity {

        // TODO: Declare member variables here:
        Button mTrueButton;
        Button mFalseButton;
        TextView mScoreTextView;
        TextView mQuetionTextView;
        ProgressBar mProgressBar;
        int mScore;
        int mQuetion;
        Random r = new Random();
        int mindex1;
        int end=0 ;
        ArrayList<Integer> listshow = new ArrayList<>();

        // TODO: Uncomment to create question bank
        private TrueFalse[] mQuestionBank = new TrueFalse[] {
                new TrueFalse(R.string.question_1, true),
                new TrueFalse(R.string.question_2, false),
                new TrueFalse(R.string.question_3, true),
                new TrueFalse(R.string.question_4, true),
                new TrueFalse(R.string.question_5, true),
                new TrueFalse(R.string.question_6, false),
                new TrueFalse(R.string.question_7, true),
                new TrueFalse(R.string.question_8, false),
                new TrueFalse(R.string.question_9, true),
                new TrueFalse(R.string.question_10, true),
                new TrueFalse(R.string.question_11, false),
                new TrueFalse(R.string.question_12, true),
                new TrueFalse(R.string.question_13,true)
        };
        // TODO: Declare constants here
        final int PROGRESS_BAR_INCREMENT = (int)Math.ceil(100.0/ 13);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (savedInstanceState!=null){
                mScore=savedInstanceState.getInt("ScoreKey");
                mindex1=savedInstanceState.getInt("IndexKey");
            }else{
                mScore=0;
                mindex1=0;
            }
            mTrueButton = findViewById(R.id.true_button);
            mFalseButton= findViewById(R.id.false_button);
            mQuetionTextView = findViewById(R.id.question_text_view);
            mScoreTextView = findViewById(R.id.score);
            mProgressBar = findViewById(R.id.progress_bar);

            mScoreTextView.setText("Score"+mScore+"/"+13);
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   checkAnswer(true);
                                                   end++;
                                                   updateQuetion();
                                               }
                                           }
            );
            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(false);
                    end++;
                    updateQuetion();

                }
            });


        }
        private void updateQuetion() {
            mindex1 = r.nextInt(mQuestionBank.length);
            if (end==13) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game Over");
                alert.setCancelable(false);
                if (mScore<=4){
                    alert.setMessage("You Scored" + mScore + "Point!" + " you aren't Ahlawy");
                }else if (mScore>=5 && mScore<= 8) {
                    alert.setMessage("You Scored" + mScore + "Point!" + " increase your information");
                }else if (mScore>=9 && mScore<= 11){
                        alert.setMessage("You Scored" + mScore + "Point!" + "  you are good");
                } else {
                    alert.setMessage("You Scored" + mScore + "Point!" + "  you are Ahlawy");
                }

                alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.show();
            }

            mQuetion = mQuestionBank[mindex1].getmQuetionID();

            if (listshow.contains(mQuetion)) {
                updateQuetion();
            }else {
                listshow.add(mQuetion);
            }

            mQuetionTextView.setText(mQuetion);
            mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
            mScoreTextView.setText("Score" + mScore + "/" + 13);

            }

        private void checkAnswer (boolean userSelection){
            boolean correctAnswer = mQuestionBank[mindex1].isAnswer();
            if (userSelection==correctAnswer){
                Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                mScore=mScore+1;
            }else {
                Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }

        }
        @Override
        public void onSaveInstanceState(Bundle outStat){
            super.onSaveInstanceState(outStat);
            outStat.putInt("ScoreKey",mScore);
            outStat.putInt("IndexKey",mindex1);
        }
    }

