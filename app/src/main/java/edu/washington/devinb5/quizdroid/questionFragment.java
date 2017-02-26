package edu.washington.devinb5.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link questionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link questionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionFragment extends Fragment {

    private ArrayList<String> answers;
    private String question, correctAnswer, answer;
    private Button choice1, choice2, choice3, choice4;
    private boolean btnChecked = false;

    private OnFragmentInteractionListener mListener;

    public questionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("HELLO READER", "Arguments are established 2");
        if (getArguments() != null) {
            answers = getArguments().getStringArrayList("answers");
            question = getArguments().getString("question");
            correctAnswer = getArguments().getString("answer");
        } else {
            answers = new ArrayList<String>();
            question = "What is life?";
            correctAnswer = "you";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView questionText = (TextView) view.findViewById(R.id.text_question);
        questionText.setText(question);

        Button submit = (Button) view.findViewById(R.id.btn_submit);
        choice1 = (Button) view.findViewById(R.id.btn_ans1);
        choice2 = (Button) view.findViewById(R.id.btn_ans2);
        choice3 = (Button) view.findViewById(R.id.btn_ans3);
        choice4 = (Button) view.findViewById(R.id.btn_ans4);
        choice1.setText(answers.get(0));
        choice2.setText(answers.get(1));
        choice3.setText(answers.get(2));
        choice4.setText(answers.get(3));

        choice1.setOnClickListener(new answerListener());
        choice2.setOnClickListener(new answerListener());
        choice3.setOnClickListener(new answerListener());
        choice4.setOnClickListener(new answerListener());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnChecked) {
                    Log.v("Submit button says: ", "You made it");
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment af = new answerFragment();
                    Bundle bl = new Bundle();

                    bl.putString("correctAnswer", correctAnswer);
                    bl.putString("answer", answer);
                    af.setArguments(bl);
                    ft.replace(R.id.topic_overview, af);
                    ft.commit();


                }

            }
        });
        return view;
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
                    answer = choice3.getText().toString();
                    break;
                case R.id.btn_ans4:
                    answer = choice4.getText().toString();
                    break;




            }

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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
