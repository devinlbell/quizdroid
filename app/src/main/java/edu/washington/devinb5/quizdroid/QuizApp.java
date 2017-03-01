package edu.washington.devinb5.quizdroid;


import android.app.Application;
import android.util.Log;

/**
 * Created by dvn02 on 2/28/2017.
 */

public class QuizApp extends Application{
    public static final String TAG = "QuizApp";

    @Override
    public void onCreate() {
        Log.v("QUIZAPP", "This is being run");
    }

}
