package edu.washington.devinb5.quizdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link topicOverviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link topicOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class topicOverviewFragment extends Fragment {
    private String topic, description;
    private int numQuestions;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public topicOverviewFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment topicOverviewFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static topicOverviewFragment newInstance(String param1, String param2) {
//
//        topicOverviewFragment fragment = new topicOverviewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("FUCK YOU FRAGMENTS", "" + savedInstanceState);
        if (getArguments() != null) {
            //Log.v("HELLO FRAGMENT", "" + getArguments().getStringArrayList("Stuff").get(0));
            topic = getArguments().getString("Topic");
            description = getArguments().getString("Description");
            numQuestions = getArguments().getInt("numQuestions");

        } else {
            topic = "Your mom";
            description = "Learn about where you came from";
            numQuestions = 10;
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
        TextView descriptionText = (TextView) view.findViewById(R.id.body_description);
        descriptionText.setText("Description: " + description);
        TextView numText = (TextView) view.findViewById(R.id.body_numQuestions);
        numText.setText("Number of Questions: " + numQuestions);
        Log.v("JELLO READER", "WE FOUND THE BUTTON");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                // topicOverviewFragment topicOverview = new topicOverviewFragment();
                ft.replace(R.id.topic_overview, new topicOverviewFragment());
                ft.commit();

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
