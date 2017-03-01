package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class QuizActivity extends Activity {
    private int numQuestions;
    private String description, topic;
    private String[] topicInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent = getIntent();
        topic = intent.getStringExtra(MainActivity.EXTRA);
        Bundle viewInfo = new Bundle();
        viewInfo.putString("Topic", topic);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        topicOverviewFragment topicOverview = new topicOverviewFragment();
        topicOverview.setArguments(viewInfo);

        ft.replace(R.id.topic_overview, topicOverview);
        ft.commit();



    }

}
