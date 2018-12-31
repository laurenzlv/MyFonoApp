package be.thomasmore.myfonoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    MediaPlayer player;

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

        getActivity().setTitle("Zeg het zelf eens");


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_zeg_het_zelf, container, false);

        ListView lv = (ListView) view.findViewById(R.id.lv);
        Button btnSpelKnop = (Button) view.findViewById(R.id.knopspel);
        loadKlanken();

        final List<Klank> list = getList();
        final List<String> listwoorden = new ArrayList<>();

        for(int i = 0; i < list.size() ; i++){
            String woord = list.get(i).getWoord();
            listwoorden.add(woord);
        }
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                listwoorden
        );

        lv.setAdapter(listViewAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                player = new MediaPlayer();
                String afb = list.get(position).getAfbeelding();
                String audiofile = list.get(position).getWoord();
                Toast ImageToast = new Toast(getContext());
                ImageView image = new ImageView(getContext());

                image.setImageResource(getImageId(afb));
                ImageToast.setView(image);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();

                player = MediaPlayer.create(getContext(),getAudiofileId(audiofile));
                player.start();
            }
        });

        btnSpelKnop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.replace(R.id.flContent, new SpelFragment());
                tx.commit();
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

    public int getAudiofileId(String filename) {
        return getContext().getResources().getIdentifier("raw/" + filename, null, getContext().getPackageName());
    }

    public int getImageId(String imageName) {
        return getContext().getResources().getIdentifier("drawable/" + imageName, null, getContext().getPackageName());
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

    public List<Klank> getList(){

        List<Klank> list;
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int keuzeId = pref.getInt("keuze",0);

            switch (keuzeId) {
                case 2131230893: list = listGSV;
                    break;
                case 2131230891: list = listGK;
                    break;
                case 2131230895: list = listKTI;
                    break;
                case 2131230894: list = listKTF;
                    break;
                case 2131230892: list = listGS;
                    break;
                case 2131230896: list = listNGN;
                    break;
                case 2131230890: list = listFT;
                    break;
                case 2131230897: list = listST;
                    break;
                case 2131230889: list = listCHT;
                    break;
                case 2131230898: list = listSZT;
                    break;
                default: list = listSZT;
                    break;

            }

            return list;
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
