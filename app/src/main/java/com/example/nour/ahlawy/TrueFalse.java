package com.example.nour.ahlawy;

public class TrueFalse {
    private int mQuetionID ;
    private  boolean mAnswer;
    public TrueFalse(int quetionResourceID,boolean trueOrFalse){
        mQuetionID=quetionResourceID;
        mAnswer = trueOrFalse;
    }

    public int getmQuetionID() {
        return mQuetionID;
    }
    public void setmQuetionID(int mQuetionID) {
        this.mQuetionID = mQuetionID;
    }
    public boolean isAnswer() {
        return mAnswer;
    }
    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

}
