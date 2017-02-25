package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class topicOverview extends Activity {
    private int numQuestions;
    private String description, topic;
    private String[] topicInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);
        Intent intent = getIntent();
        topic = intent.getStringExtra(MainActivity.EXTRA);
        populateTopicInfo();
        ArrayList<String> topicStuff = new ArrayList<String>();
        topicStuff.add(topic);
        Bundle viewInfo = new Bundle();
        viewInfo.putString("Topic", topic);
        viewInfo.putString("Description", description);
        viewInfo.putInt("numQuestions", numQuestions);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        topicOverviewFragment topicOverview = new topicOverviewFragment();
        topicOverview.setArguments(viewInfo);
        ft.replace(R.id.topic_overview, topicOverview);
        ft.commit();



    }

    public void populateTopicInfo() {
        switch(topic) {
            case "Math":
                description = "Math teaches you the fundamentals of numeric values";
                numQuestions = 1;
                break;
            case "Physics":
                description = "Physics teaches you the fundamentals of the physical world";
                numQuestions = 1;
                break;
            case "Music":
                description = "Test your pop culture knowledge, or knowledge of instruments. We're indecisive about topics.";
                numQuestions = 1;
                break;
            case "Marvel Super Heroes":
                description = "Test your knowledge of marvel super heroes. No villains please";
                numQuestions = 1;
                break;
        }
    }
}
