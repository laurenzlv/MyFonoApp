package be.thomasmore.myfonoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ZegHetZelfFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ZegHetZelfFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZegHetZelfFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    List<Klank> listKTF;
    List<Klank> listGS;
    List<Klank> listNGN;
    List<Klank> listKTI;
    List<Klank> listGSV;
    List<Klank> listST;
    List<Klank> listCHT;
    List<Klank> listGK;
    List<Klank> listSZT;
    List<Klank> listFT;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ZegHetZelfFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ZegHetZelfFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ZegHetZelfFragment newInstance(String param1, String param2) {
        ZegHetZelfFragment fragment = new ZegHetZelfFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zeg_het_zelf, container, false);

        loadKlanken();
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

    public void loadKlanken(){
        listFT = new ArrayList<>();
        listSZT = new ArrayList<>();
        listGK = new ArrayList<>();
        listCHT = new ArrayList<>();
        listST = new ArrayList<>();
        listKTI = new ArrayList<>();
        listKTF = new ArrayList<>();
        listNGN = new ArrayList<>();
        listGS = new ArrayList<>();
        listGSV = new ArrayList<>();

        listKTF.add(new Klank("bad","tekeningbad"));
        listKTF.add(new Klank("bak","tekeningbak"));
        listKTF.add(new Klank("bed","tekeningbed"));
        listKTF.add(new Klank("net","tekeningnet2"));
        listKTF.add(new Klank("nek","tekeningnek"));

        listGS.add(new Klank("buig","tekeningbuig"));
        listGS.add(new Klank("buis","tekeningbuis"));
        listGS.add(new Klank("dag","tekeningdag"));
        listGS.add(new Klank("leeg","tekeningleeg"));
        listGS.add(new Klank("lees","tekeninglees"));

        listNGN.add(new Klank("pan","tekeningpan"));
        listNGN.add(new Klank("pang","tekeningpang"));
        listNGN.add(new Klank("ton","tekenington"));
        listNGN.add(new Klank("tong","tekeningtong"));

        listKTI.add(new Klank("kam","tekeningkam"));
        listKTI.add(new Klank("tam","tam"));
        listKTI.add(new Klank("koe","tekeningkoe"));
        listKTI.add(new Klank("toe","tekeningtoe"));
        listKTI.add(new Klank("kou","kou"));
        listKTI.add(new Klank("touw","tekeningtouw"));

        listGSV.add(new Klank("gat","gat"));
        listGSV.add(new Klank("goud","goud"));
        listGSV.add(new Klank("fout","tekeningfout"));
        listGSV.add(new Klank("goed","tekeninggoed"));
        listGSV.add(new Klank("guus","tekeningguus"));
        listGSV.add(new Klank("suus","tekeningsuus"));
        listGSV.add(new Klank("voet","tekeningvoet"));

        listST.add(new Klank("boos","tekeningboos"));
        listST.add(new Klank("boot","tekeningboot"));
        listST.add(new Klank("bos","tekeningbos"));
        listST.add(new Klank("bot","tekeningbot"));
        listST.add(new Klank("das","stropdas"));

        listCHT.add(new Klank("buig","tekeningbuig"));
        listCHT.add(new Klank("dag","tekeningdag"));
        listCHT.add(new Klank("leeg","tekeningleeg"));
        listCHT.add(new Klank("pech","pech"));
        listCHT.add(new Klank("pet","pet"));

        listGK.add(new Klank("gat","gat"));
        listGK.add(new Klank("guus","tekeningguus"));
        listGK.add(new Klank("goed","tekeninggoed"));
        listGK.add(new Klank("kat","kat"));
        listGK.add(new Klank("goud","goud"));

        listSZT.add(new Klank("sok","tekeningsok"));
        listSZT.add(new Klank("suus","tekeningsuus"));
        listSZT.add(new Klank("zak","tekeningzak"));
        listSZT.add(new Klank("tak","tekeningtak"));
        listSZT.add(new Klank("tok","tok"));

        listFT.add(new Klank("fee","fee"));
        listFT.add(new Klank("fien","tekeningfien"));
        listFT.add(new Klank("fout","tekeningfout"));
        listFT.add(new Klank("thee","tekeningthee"));
        listFT.add(new Klank("tien","tien"));

    }
}
