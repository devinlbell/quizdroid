package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity{
    public final static String EXTRA = "com.devinb5.uw.edu.EXTRA";
    private ListView topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] topicNames = {"Math", "Physics", "Marvel Super Heroes", "Music"};
        topics = (ListView) findViewById(R.id.lvTopics);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, topicNames);
        topics.setAdapter(adapter);
        topics.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, QuizActivity.class);

                i.putExtra(EXTRA, (String) topics.getItemAtPosition(position));
                startActivity(i);
            }
        });

    }

}
