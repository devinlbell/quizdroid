package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
    public final static String EXTRA = "com.devinb5.uw.edu.EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button math = (Button) findViewById(R.id.btn_math);
        Button physics = (Button) findViewById(R.id.btn_physics);
        Button marvel = (Button) findViewById(R.id.btn_marvel);
        Button music = (Button) findViewById(R.id.btn_music);
        math.setOnClickListener(new topicListener());
        physics.setOnClickListener(new topicListener());
        marvel.setOnClickListener(new topicListener());
        music.setOnClickListener(new topicListener());

    }

    public class topicListener implements View.OnClickListener {


        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, topicOverview.class);
            switch (v.getId()) {
                case R.id.btn_math:
                    String[] maths = {"Math", "Math teaches you the fundamentals of numeric values", "1"};
                    intent.putExtra(EXTRA, maths);
                case R.id.btn_physics:
                    String[] physics = {"Physics", "Math teaches you the fundamentals of the physical world", "1"};
                    intent.putExtra(EXTRA, physics);
                case R.id.btn_marvel:
                    String[] marvels = {"Marvel", "Test your knowledge of marvel super heroes. No villains please", "1"};
                    intent.putExtra(EXTRA, marvels);
                case R.id.btn_music:
                    String[] music = {"Music", "Test your pop culture knowledge, or knowledge of instruments. We're indecisive about topics.", "1"};
                    intent.putExtra(EXTRA, music);
            }
            startActivity(intent);

        }
    }
}
