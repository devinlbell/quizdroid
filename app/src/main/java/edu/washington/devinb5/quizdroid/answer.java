package edu.washington.devinb5.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class answer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Log.v("Answer says: ", "You made it");
        Intent intent = getIntent();
        String answer = intent.getStringExtra(question.Q_EXTRA);
        int corTotal = 0;
        int total = 1;
        String correctAnswer = "Three";
        TextView userAns = (TextView) findViewById(R.id.ans_user);
        userAns.setText("You answered " + answer + ".");
        TextView corAns = (TextView) findViewById(R.id.ans_correct);
        corAns.setText("The correct answer is " + correctAnswer + ".");
        TextView summary = (TextView) findViewById(R.id.ans_summary);

        if(answer.equals(correctAnswer)) {
            corTotal += 1;

        }
        summary.setText("You have answered " + corTotal + " out of " + total + " questions correctly.");
        Button finish = (Button) findViewById(R.id.btn_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent end = new Intent(answer.this, MainActivity.class);
                startActivity(end);
            }
        });

    }
}
