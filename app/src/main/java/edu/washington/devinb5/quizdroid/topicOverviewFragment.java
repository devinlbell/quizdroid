package edu.washington.devinb5.quizdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;



public class topicOverviewFragment extends Fragment {
    private String topic, description, question, answer;
    private int numQuestions;
    private ArrayList<String> answers;


    private OnFragmentInteractionListener mListener;

    public topicOverviewFragment() {
        // Required empty public constructor

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            topic = getArguments().getString("Topic");

//            numQuestions = getArguments().getInt("numQuestions");

        } else {
            topic = "Your mom";

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_topic_overview, container, false);
        Button start = (Button) view.findViewById(R.id.btn_start);
        TextView topicText = (TextView) view.findViewById(R.id.hdr_topic);
        topicText.setText("Topic: " + topic);
        populateTopicInfo();
        TextView descriptionText = (TextView) view.findViewById(R.id.body_description);
        descriptionText.setText("Description: " + description);
        TextView numText = (TextView) view.findViewById(R.id.body_numQuestions);
        numText.setText("Number of Questions: " + numQuestions);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                // topicOverviewFragment QuizActivity = new topicOverviewFragment();
                Fragment qf = new questionFragment();
                Bundle bl = new Bundle();

                bl.putString("question", question);
                bl.putString("answer", answer);
                bl.putStringArrayList("answers", answers);
                qf.setArguments(bl);
                ft.replace(R.id.topic_overview, qf);
                ft.commit();


            }
        });
        return view;
    }

    public void populateTopicInfo() {
        switch(topic) {
            case "Math":
                description = "Math teaches you the fundamentals of numeric values";
                numQuestions = 1;
                question = "What is the sum of 1 + 1?";
                answer = "2";
                answers = new ArrayList<String>();
                answers.add("1");
                answers.add("a window");
                answers.add("2");
                answers.add("It depends");
                break;
            case "Physics":
                description = "Physics teaches you the fundamentals of the physical world";
                numQuestions = 1;
                question = "What is the velocity of gravity?";
                answer = "9.81 meters squared per second";
                answers = new ArrayList<String>();
                answers.add("5 ft per second");
                answers.add("The time it takes for me to hit the ground");
                answers.add("9.81 meters squared per second");
                answers.add("It depends");
                break;
            case "Music":
                description = "Test your pop culture knowledge, or knowledge of instruments. We're indecisive about topics.";
                numQuestions = 1;
                question = "How many strings does a standard guitar have?";
                answer = "6";
                answers = new ArrayList<String>();
                answers.add("4");
                answers.add("Two more than the amount of answers");
                answers.add("6");
                answers.add("It depends");
                break;
            case "Marvel Super Heroes":
                description = "Test your knowledge of marvel super heroes. No villains please";
                numQuestions = 1;
                question = "Which one of these characters has not had Spider-man's powers?";
                answer = "Dr. Strange";
                answers = new ArrayList<String>();
                answers.add("Kaine");
                answers.add("J. Jonah Jameson");
                answers.add("Dr. Strange");
                answers.add("Ben Reilly");
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
