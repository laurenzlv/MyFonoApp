package be.thomasmore.myfonoapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LuisterGoedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LuisterGoedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LuisterGoedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    GlobalState gs;
    private OnFragmentInteractionListener mListener;
    MediaPlayer player;
    ImageButton playbtn;
    ImageButton pausebtn;
    ImageButton stopbtn;

    public LuisterGoedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LuisterGoedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LuisterGoedFragment newInstance(String param1, String param2) {
        LuisterGoedFragment fragment = new LuisterGoedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        gs = (GlobalState) getActivity().getApplication();
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View RootView = inflater.inflate(R.layout.fragment_luister_goed, container, false);


        playbtn = (ImageButton) RootView.findViewById(R.id.play);
        pausebtn = (ImageButton) RootView.findViewById(R.id.pause);
        stopbtn = (ImageButton) RootView.findViewById(R.id.stopp);

        playbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Toast.makeText(getActivity(), "play", Toast.LENGTH_SHORT).show();
                if (player == null){
                    setAudioFile();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                }
                player.start();
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Toast.makeText(getActivity(), "pause", Toast.LENGTH_SHORT).show();
                if (player != null){
                    player.pause();
                }
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Toast.makeText(getActivity(), "stop", Toast.LENGTH_SHORT).show();
                stopPlayer();
            }
        });


        return RootView;
    }

    private void setAudioFile(){

        int keuzeId = 0; //hier keuze uit localstorage VAN id geen text.string want 2 x K-T

        switch (keuzeId) {
            case 2131230874:  player = MediaPlayer.create(getContext(), R.raw.reeks1);
            case 2131230872:  player = MediaPlayer.create(getContext(), R.raw.reeks3);
            case 2131230876:  player = MediaPlayer.create(getContext(), R.raw.reeks5);
            case 2131230875:  player = MediaPlayer.create(getContext(), R.raw.reeks2);
            case 2131230873:  player = MediaPlayer.create(getContext(), R.raw.reeks4);
            case 2131230877:  player = MediaPlayer.create(getContext(), R.raw.reeks6);
            case 2131230869:  player = MediaPlayer.create(getContext(), R.raw.reeks3);
            case 2131230871:  player = MediaPlayer.create(getContext(), R.raw.reeks4);
            case 2131230878:  player = MediaPlayer.create(getContext(), R.raw.reeks7en8);
            case 2131230870:  player = MediaPlayer.create(getContext(), R.raw.reeks9);
                break;
            default: break;
        }
    }

    private void stopPlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        stopPlayer();
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
