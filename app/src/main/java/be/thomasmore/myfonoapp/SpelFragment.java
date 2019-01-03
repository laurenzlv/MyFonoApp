package be.thomasmore.myfonoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SpelFragment extends Fragment {
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
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    List<Klank> spelList = new ArrayList<>();
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    String latestClicked = "";
    int latestClickednr;
    String latestKeuzeLinks = "";
    String latestKeuzeRechts = "";
    int score = 0;
    TextView tv;
    int zilver;
    int goud;
    Button newgame;

    public SpelFragment() {
        // Required empty public constructor
    }


    public static SpelFragment newInstance(String param1, String param2) {
        SpelFragment fragment = new SpelFragment();
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
        final View RootView = inflater.inflate(R.layout.fragment_spel, container, false);
        loadlist();
        spelList = getList();

        img1 = RootView.findViewById(R.id.img1);
        img2 = RootView.findViewById(R.id.img2);
        img3 = RootView.findViewById(R.id.img3);
        img4 = RootView.findViewById(R.id.img4);
        img5 = RootView.findViewById(R.id.img5);
        img6 = RootView.findViewById(R.id.img6);
        img7 = RootView.findViewById(R.id.img7);
        img8 = RootView.findViewById(R.id.img8);
        img9 = RootView.findViewById(R.id.img9);
        img10 = RootView.findViewById(R.id.img10);
        img11 = RootView.findViewById(R.id.img11);
        tv = RootView.findViewById(R.id.scoreid);
        newgame = RootView.findViewById(R.id.nieuwspel);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.replace(R.id.flContent, new SpelFragment());
                tx.commit();
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img1.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 1;
                setKeuze(lukraak,lukr);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img2.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 2;
                setKeuze(lukraak,lukr);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img3.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 3;
                setKeuze(lukraak,lukr);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img4.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 4;
                setKeuze(lukraak,lukr);

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img5.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 5;
                setKeuze(lukraak,lukr);

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img6.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 6;
                setKeuze(lukraak,lukr);

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img7.setImageResource(getImageId(image));
                latestClickednr = 7;
                latestClicked = spelList.get(lukraak).getAfbeelding();

                setKeuze(lukraak,lukr);

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img8.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 8;
                setKeuze(lukraak,lukr);

            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*spelList.size());
                int lukr = (int) (Math.random()*2)+1;
                String image = spelList.get(lukraak).getAfbeelding();
                img9.setImageResource(getImageId(image));

                latestClicked = spelList.get(lukraak).getAfbeelding();
                latestClickednr = 9;
                setKeuze(lukraak,lukr);

            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player;

                if(!latestClicked.equals("")){
                if(latestKeuzeLinks.equals(latestClicked))
                {
                    player = MediaPlayer.create(getContext(),getAudiofileId("correct"));
                    player.start();
                    score += 10;
                    showScore();
                }else
                {
                    player = MediaPlayer.create(getContext(),getAudiofileId("incorrect"));
                    player.start();
                    score -= 15;
                    showScore();
                    reset();
                }
            }
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player;

                if(!latestClicked.equals("")){
                if(latestClicked.equals(latestKeuzeRechts))
                {
                    player = MediaPlayer.create(getContext(),getAudiofileId("correct"));
                    player.start();
                    score += 10;
                    showScore();
                }else
                {
                    player = MediaPlayer.create(getContext(),getAudiofileId("incorrect"));
                    player.start();
                    score -= 15;
                    showScore();
                    reset();
                }
            }
            }
        });


        return RootView;
    }

    public void reset(){
        img10.setImageResource(getImageId("varken"));
        img11.setImageResource(getImageId("varken"));
        switch (latestClickednr) {
            case 1: img1.setImageResource(getImageId("varken"));
                break;
            case 2: img2.setImageResource(getImageId("varken"));
                break;
            case 3: img3.setImageResource(getImageId("varken"));
                break;
            case 4: img4.setImageResource(getImageId("varken"));
                break;
            case 5: img5.setImageResource(getImageId("varken"));
                break;
            case 6: img6.setImageResource(getImageId("varken"));
                break;
            case 7: img7.setImageResource(getImageId("varken"));
                break;
            case 8: img8.setImageResource(getImageId("varken"));
                break;
            case 9: img9.setImageResource(getImageId("varken"));
                break;

        }

    }

    public void showScore(){
        String s = String.valueOf(score);
        tv.setText(s);



        if(score == 40){

            MediaPlayer player;
            player = MediaPlayer.create(getContext(),getAudiofileId("goedzo"));
            player.start();
            }



        if(score > 79 && score < 86){

            SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
            int aantal = pref.getInt("spel1Medailles", 0);


            int aantalsuper = pref.getInt("spel1MedaillesSuper", 0);


            if (aantal == 0){
                SharedPreferences.Editor edt = pref.edit();
                edt.putInt("spel1Medailles", 1);
                edt.commit();

                Toast ImageToast = new Toast(getContext());
                ImageView image = new ImageView(getContext());

                image.setImageResource(getImageId("minimedaille1"));
                ImageToast.setView(image);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();
            }
            else if (aantal < 6){

                SharedPreferences.Editor edt = pref.edit();
                edt.putInt("spel1Medailles", aantal + 1);
                edt.commit();


                Toast ImageToast = new Toast(getContext());
                ImageView image = new ImageView(getContext());

                image.setImageResource(getImageId("minimedaille1"));
                ImageToast.setView(image);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();
            }
            else if (aantal > 5 && aantalsuper != 0){
                SharedPreferences.Editor edt = pref.edit();
                edt.putInt("spel1MedaillesSuper",   aantalsuper + 1);
                edt.commit();

                edt.putInt("spel1Medailles", 0);
                edt.commit();

                Toast ImageToast = new Toast(getContext());
                ImageView image = new ImageView(getContext());
                image.setImageResource(getImageId("supermedaille1"));
                ImageToast.setView(image);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();
            }
            else if (aantal > 5 && aantalsuper == 0){
                SharedPreferences.Editor edt = pref.edit();
                edt.putInt("spel1MedaillesSuper",   1);
                edt.commit();

                edt.putInt("spel1Medailles", 0);
                edt.commit();

                Toast ImageToast = new Toast(getContext());
                ImageView image = new ImageView(getContext());
                image.setImageResource(getImageId("supermedaille1"));
                ImageToast.setView(image);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();
            }




            MediaPlayer player;
            player = MediaPlayer.create(getContext(),getAudiofileId("goedgedaan"));
            player.start();

        }


    }

    public int getAudiofileId(String filename) {
        return getContext().getResources().getIdentifier("raw/" + filename, null, getContext().getPackageName());
    }

    public void setKeuze(int lukraak, int lukr){

        for(int i = 0; i < spelList.size() ; i++){

            if(spelList.get(i).getPaar() == spelList.get(lukraak).getPaar())
                if(spelList.get(i).getId() != spelList.get(lukraak).getId()) {
                    if (lukr == 1) {
                        img10.setImageResource(getImageId(spelList.get(i).getAfbeelding()));
                        img11.setImageResource(getImageId(spelList.get(lukraak).getAfbeelding()));

                        latestKeuzeLinks = spelList.get(i).getAfbeelding();
                        latestKeuzeRechts = spelList.get(lukraak).getAfbeelding();

                    } else {
                        img10.setImageResource(getImageId(spelList.get(lukraak).getAfbeelding()));
                        img11.setImageResource(getImageId(spelList.get(i).getAfbeelding()));

                        latestKeuzeRechts = spelList.get(i).getAfbeelding();
                        latestKeuzeLinks = spelList.get(lukraak).getAfbeelding();
                    }
                }else
                {
                    for(int b = 0; b < spelList.size() ; b++){
                        if(spelList.get(b).getPaar() == spelList.get(lukraak).getPaar() && spelList.get(b).getId() != spelList.get(lukraak).getId()){
                            if (lukr == 1) {
                                img10.setImageResource(getImageId(spelList.get(b).getAfbeelding()));
                                img11.setImageResource(getImageId(spelList.get(lukraak).getAfbeelding()));

                                latestKeuzeLinks = spelList.get(b).getAfbeelding();
                                latestKeuzeRechts = spelList.get(lukraak).getAfbeelding();
                            } else {
                                img10.setImageResource(getImageId(spelList.get(lukraak).getAfbeelding()));
                                img11.setImageResource(getImageId(spelList.get(b).getAfbeelding()));

                                latestKeuzeRechts = spelList.get(b).getAfbeelding();
                                latestKeuzeLinks = spelList.get(lukraak).getAfbeelding();
                            }
                        }
                    }
                }
        }
    }

    public int getImageId(String imageName) {
        return getContext().getResources().getIdentifier("drawable/" + imageName, null, getContext().getPackageName());
    }

    public void loadlist(){
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

        //listGSV.add(new Klank("gat","gat"));
        listGSV.add(new Klank(0,"goud","goud",1));
        listGSV.add(new Klank(1,"fout","tekeningfout",1));
        listGSV.add(new Klank(2,"goed","tekeninggoed",2));
        listGSV.add(new Klank(3,"voet","tekeningvoet",2));
        listGSV.add(new Klank(4,"guus","tekeningguus",3));
        listGSV.add(new Klank(5,"suus","tekeningsuus",3));


        listKTF.add(new Klank(0,"bad","tekeningbad",1));
        listKTF.add(new Klank(1,"bak","tekeningbak",1));
        //listKTF.add(new Klank(2,"bed","tekeningbed"));
        listKTF.add(new Klank(3,"net","tekeningnet2",2));
        listKTF.add(new Klank(4,"nek","tekeningnek",2));

        listGS.add(new Klank(0,"buig","tekeningbuig",1));
        listGS.add(new Klank(1,"buis","tekeningbuis",1));
        listGS.add(new Klank(2,"dag","tekeningdag",2));
        listGS.add(new Klank(3,"das","stropdas",2));
        listGS.add(new Klank(4,"leeg","tekeningleeg",3));
        listGS.add(new Klank(5,"lees","tekeninglees",3));

        listNGN.add(new Klank(0,"pan","tekeningpan",1));
        listNGN.add(new Klank(1,"pang","tekeningpang",1));
        listNGN.add(new Klank(2,"ton","tekenington",2));
        listNGN.add(new Klank(3,"tong","tekeningtong",2));

        listKTI.add(new Klank(0,"kam","tekeningkam",1));
        listKTI.add(new Klank(1,"tam","tam",1));
        listKTI.add(new Klank(2,"koe","tekeningkoe",2));
        listKTI.add(new Klank(3,"toe","tekeningtoe",2));
        listKTI.add(new Klank(4,"kou","kou",3));
        listKTI.add(new Klank(5,"touw","tekeningtouw",3));

        listST.add(new Klank(0,"boos","tekeningboos",1));
        listST.add(new Klank(1,"boot","tekeningboot",1));
        listST.add(new Klank(2,"bos","tekeningbos",2));
        listST.add(new Klank(3,"bot","tekeningbot",2));
        //listST.add(new Klank("das","stropdas"));

        //listCHT.add(new Klank("buig","tekeningbuig"));
        //listCHT.add(new Klank("dag","tekeningdag"));
        //listCHT.add(new Klank("leeg","tekeningleeg"));
        listCHT.add(new Klank(0,"pech","pech",1));
        listCHT.add(new Klank(1,"pet","pet",1));

        listGK.add(new Klank(0,"gat","gat",1));
        //listGK.add(new Klank("guus","tekeningguus"));
        //listGK.add(new Klank("goed","tekeninggoed"));
        listGK.add(new Klank(1,"kat","kat",1));
        //listGK.add(new Klank("goud","goud"));

        listSZT.add(new Klank(0,"sok","tekeningsok",1));
        listSZT.add(new Klank(1,"tok","tok",1));
        //listSZT.add(new Klank("suus","tekeningsuus"));
        listSZT.add(new Klank(2,"zak","tekeningzak",2));
        listSZT.add(new Klank(3,"tak","tekeningtak",2));


        listFT.add(new Klank(0,"fee","fee",1));
        listFT.add(new Klank(1,"thee","tekeningthee",1));
        listFT.add(new Klank(2,"fien","tekeningfien",2));
        //listFT.add(new Klank("fout","tekeningfout"));
        listFT.add(new Klank(3,"tien","tien",2));

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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public List<Klank> getList(){

        List<Klank> list;
        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int keuzeId = pref.getInt("keuze",0);

        switch (keuzeId) {
            case 2131230891: list = listGSV;
                break;
            case 2131230889: list = listGK;
                break;
            case 2131230893: list = listKTI;
                break;
            case 2131230892: list = listKTF;
                break;
            case 2131230890: list = listGS;
                break;
            case 2131230894: list = listNGN;
                break;
            case 2131230888: list = listFT;
                break;
            case 2131230895: list = listST;
                break;
            case 2131230887: list = listCHT;
                break;
            case 2131230896: list = listSZT;
                break;
            default: list = listSZT;
                break;

        }

        return list;
    }
}
