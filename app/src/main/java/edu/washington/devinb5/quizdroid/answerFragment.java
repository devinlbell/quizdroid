package edu.washington.devinb5.quizdroid;

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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link answerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link answerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class answerFragment extends Fragment {

    private String answer, correctAnswer;
    private OnFragmentInteractionListener mListener;

    public answerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
//    public static answerFragment newInstance(String param1, String param2) {
//        answerFragment fragment = new answerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            answer = getArguments().getString("answer");
            correctAnswer = getArguments().getString("correctAnswer");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        Log.v("Answer says: ", "You made it");


        int corTotal = 0;
        int total = 1;

        TextView userAns = (TextView) view.findViewById(R.id.ans_user);
        userAns.setText("You answered " + answer + ".");
        TextView corAns = (TextView) view.findViewById(R.id.ans_correct);
        corAns.setText("The correct answer is " + correctAnswer + ".");
        TextView summary = (TextView) view.findViewById(R.id.ans_summary);

        if(answer.equals(correctAnswer)) {
            corTotal += 1;

        }
        summary.setText("You have answered " + corTotal + " out of " + total + " questions correctly.");
        Button finish = (Button) view.findViewById(R.id.btn_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent end = new Intent(getActivity(), MainActivity.class);
                startActivity(end);
            }
        });
        return view;
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
