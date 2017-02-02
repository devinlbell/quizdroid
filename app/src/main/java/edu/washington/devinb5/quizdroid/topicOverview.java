package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class topicOverview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);

        Intent intent = getIntent();
        String[] topicInfo = intent.getStringArrayExtra(MainActivity.EXTRA);
        TextView topic = (TextView) findViewById(R.id.hdr_topic);
        TextView description = (TextView) findViewById(R.id.body_description);
        TextView numQuestions = (TextView) findViewById(R.id.body_numQuestions);
        topic.setText("Topic: " + topicInfo[0]);
        description.setText("Description: " + topicInfo[1]);
        numQuestions.setText("Number of Questions: " + topicInfo[2]);

        Button start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent begin = new Intent(topicOverview.this, question.class);
                startActivity(begin);
            }
        });


    }
}
