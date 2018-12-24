package be.thomasmore.myfonoapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KeuzeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KeuzeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KeuzeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RadioGroup g1;
    RadioGroup g2;
    RadioGroup g3;
    RadioGroup g4;

    public KeuzeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KeuzeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KeuzeFragment newInstance(String param1, String param2) {
        KeuzeFragment fragment = new KeuzeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View RootView = inflater.inflate(R.layout.fragment_keuze, container, false);

        Button btnKeuzeOpslaan = (Button) RootView.findViewById(R.id.btnKeuzeOpslaan);

        btnKeuzeOpslaan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                naarStartPagina(v);
            }
        });

        g1= RootView.findViewById(R.id.g1);
        g2= RootView.findViewById(R.id.g2);
        g3= RootView.findViewById(R.id.g3);
        g4= RootView.findViewById(R.id.g4);


        g1.setOnCheckedChangeListener(mRG1Listener);
        g2.setOnCheckedChangeListener(mRG2Listener);
        g3.setOnCheckedChangeListener(mRG3Listener);
        g4.setOnCheckedChangeListener(mRG4Listener);

        return RootView;
    }

    private RadioGroup.OnCheckedChangeListener mRG3Listener = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            uncheckOtherRadioGroups(g2,g1,g4);
        }
    };
    private RadioGroup.OnCheckedChangeListener mRG1Listener = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            uncheckOtherRadioGroups(g2,g3,g4);
        }
    };
    private RadioGroup.OnCheckedChangeListener mRG2Listener = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            uncheckOtherRadioGroups(g3,g1,g4);
        }
    };
    private RadioGroup.OnCheckedChangeListener mRG4Listener = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            uncheckOtherRadioGroups(g2,g1,g3);
        }
    };

    public void uncheckOtherRadioGroups(RadioGroup rg1,RadioGroup rg2,RadioGroup rg3){
        g1.setOnCheckedChangeListener(null);
        g2.setOnCheckedChangeListener(null);
        g3.setOnCheckedChangeListener(null);
        g4.setOnCheckedChangeListener(null);

        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();

        g1.setOnCheckedChangeListener(mRG1Listener);
        g2.setOnCheckedChangeListener(mRG2Listener);
        g3.setOnCheckedChangeListener(mRG3Listener);
        g4.setOnCheckedChangeListener(mRG4Listener);
    }

    public void keuzeOpslaan(View v){
        // KEUZE OPSLAAN
        //ALS SESSION VARIABLE
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


    public void naarStartPagina(View v){
        geefKeuze();
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.flContent, new StartpaginaFragment());
        tx.commit();
    }

    public int geefKeuze(){
        RadioButton checkedRadioButton = (RadioButton) getView().findViewById(R.id.rbK_T_fin);;

        RadioGroup rg1 = getView().findViewById(R.id.g1);
        RadioGroup rg2 = getView().findViewById(R.id.g2);
        RadioGroup rg3 = getView().findViewById(R.id.g3);
        RadioGroup rg4 = getView().findViewById(R.id.g4);

        int rg1s = rg1.getCheckedRadioButtonId();
        int rg2s = rg2.getCheckedRadioButtonId();
        int rg3s = rg3.getCheckedRadioButtonId();
        int rg4s = rg4.getCheckedRadioButtonId();

        if(rg1s != -1){
            checkedRadioButton = (RadioButton) getView().findViewById(rg1s);
        }
        if(rg2s != -1){
            checkedRadioButton = (RadioButton) getView().findViewById(rg2s);
        }
        if(rg3s != -1){
            checkedRadioButton = (RadioButton) getView().findViewById(rg3s);
        }
        if(rg4s != -1){
            checkedRadioButton = (RadioButton) getView().findViewById(rg4s);
        }

        Toast.makeText(getActivity(), checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();

        return checkedRadioButton.getId();
    }




}
