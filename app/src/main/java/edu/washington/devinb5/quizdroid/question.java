package edu.washington.devinb5.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class question extends AppCompatActivity {
    public final static String Q_EXTRA = "com.devinb5.uw.edu.Q_EXTRA";
    private String answer;
    private Button choice1, choice2, choice3, choice4;
    private boolean btnChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        answer = "You haven't answered anything yet.";
        Button submit = (Button) findViewById(R.id.btn_submit);
        choice1 = (Button) findViewById(R.id.btn_ans1);
        choice2 = (Button) findViewById(R.id.btn_ans2);
        choice3 = (Button) findViewById(R.id.btn_ans3);
        choice4 = (Button) findViewById(R.id.btn_ans4);
        choice1.setOnClickListener(new answerListener());
        choice2.setOnClickListener(new answerListener());
        choice3.setOnClickListener(new answerListener());
        choice4.setOnClickListener(new answerListener());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnChecked) {
                    Log.v("Submit button says: ", "You made it");
                    Intent intent = new Intent(question.this, answer.class);
                    intent.putExtra(Q_EXTRA, answer);
                    startActivity(intent);
                }

            }
        });
    }

    public class answerListener implements View.OnClickListener {


        public void onClick(View v) {
            btnChecked = true;
            switch (v.getId()) {
                case R.id.btn_ans1:
                    answer = choice1.getText().toString();
                    break;

                case R.id.btn_ans2:
                    answer = choice2.getText().toString();
                    break;

                case R.id.btn_ans3:
                    answer = "Three";
                    break;
                case R.id.btn_ans4:
                    answer = choice4.getText().toString();
                    break;




            }

        }
    }
}
