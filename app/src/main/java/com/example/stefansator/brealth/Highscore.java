package com.example.stefansator.brealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;


public class Highscore implements Parcelable{
    private int rating;
    private int falseAnswer;
    private long duration;
    private String task;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    public Highscore(Context context, String task, boolean wipe) {
        this.task = task;
        this.preferences = context.getSharedPreferences(task,Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        if(wipe == true) {
            preferencesEditor.clear();
            preferencesEditor.apply();
        }
    }

    protected Highscore(Parcel in) {
        rating = in.readInt();
        falseAnswer = in.readInt();
        duration = in.readLong();
        task = in.readString();
    }

    public static final Creator<Highscore> CREATOR = new Creator<Highscore>() {
        @Override
        public Highscore createFromParcel(Parcel in) {
            return new Highscore(in);
        }

        @Override
        public Highscore[] newArray(int size) {
            return new Highscore[size];
        }
    };

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setFalseAnswer(int falseAnswer) {
        this.falseAnswer = falseAnswer;
    }

    public int getFalseAnswer () {
        return this.falseAnswer;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating () {
        return rating;
    }

    public String getTask() {
        return task;
    }

    public boolean isNewHighscore() {
        preferencesEditor = preferences.edit();

        int curRatingHS = preferences.getInt(task+"rating",0);
        int curfalseAnswerHS = preferences.getInt(task + "falseAnswer",Integer.MAX_VALUE);
        long curDurationHS = preferences.getLong(task + "duration", Long.MAX_VALUE);

        if (curRatingHS <= rating) {
            if (curfalseAnswerHS >= falseAnswer) {
                if (curDurationHS > duration) {
                    preferencesEditor.putInt(task + "rating", rating);
                    preferencesEditor.putInt(task+ "falseAnswer", falseAnswer);
                    preferencesEditor.putLong(task + "duration", duration);
                    preferencesEditor.apply();
                    return true;
                }
            }
        }

        setRating(curRatingHS);
        setFalseAnswer(curfalseAnswerHS);
        setDuration(curDurationHS);

        return false;
    }
    public boolean isNewHighscoreLesen() {
        preferencesEditor = preferences.edit();

        int curRatingHS = preferences.getInt(task+"rating",0);
        long curDurationHS = preferences.getLong(task + "duration", Long.MAX_VALUE);

        if (curRatingHS  <= rating){
            if (curDurationHS < duration) {
                preferencesEditor.putInt(task+"rating", rating);
                preferencesEditor.putLong(task+"duration",duration);
                preferencesEditor.apply();
                return true;
            }
        }

        setRating(curRatingHS);
        setDuration(curDurationHS);

        return false;
    }

    public boolean isNewHighscoreOnlyRatingFalse() {
        preferencesEditor = preferences.edit();

        int curRatingHS = preferences.getInt(task+"rating",0);
        int curfalseAnswerHS = preferences.getInt(task + "falseAnswer",Integer.MAX_VALUE);

        if (rating >= curRatingHS){
            if (falseAnswer < curfalseAnswerHS) {
                preferencesEditor.putInt(task+"rating", rating);
                preferencesEditor.putInt(task+"falseAnswer",falseAnswer);
                preferencesEditor.apply();
                return true;
            }
        }

        setRating(curRatingHS);
        setFalseAnswer(curfalseAnswerHS);
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeInt(falseAnswer);
        dest.writeLong(duration);
        dest.writeString(task);
    }
}
