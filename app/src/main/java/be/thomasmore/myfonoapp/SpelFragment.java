package be.thomasmore.myfonoapp;

import android.content.Context;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    List<Klank> listGSV = new ArrayList<>();
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
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img1.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 1;
                setKeuze(lukraak,lukr);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img2.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 2;
                setKeuze(lukraak,lukr);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img3.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 3;
                setKeuze(lukraak,lukr);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img4.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 4;
                setKeuze(lukraak,lukr);

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img5.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 5;
                setKeuze(lukraak,lukr);

            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img6.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 6;
                setKeuze(lukraak,lukr);

            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img7.setImageResource(getImageId(image));
                latestClickednr = 7;
                latestClicked = listGSV.get(lukraak).getAfbeelding();

                setKeuze(lukraak,lukr);

            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img8.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
                latestClickednr = 8;
                setKeuze(lukraak,lukr);

            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lukraak = (int) (Math.random()*5);
                int lukr = (int) (Math.random()*2)+1;
                String image = listGSV.get(lukraak).getAfbeelding();
                img9.setImageResource(getImageId(image));

                latestClicked = listGSV.get(lukraak).getAfbeelding();
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
        if(score == 90){
            MediaPlayer player;
            player = MediaPlayer.create(getContext(),getAudiofileId("goedgedaan"));
            player.start();
            score += 10;
            tv.setText(s);
            Toast ImageToast = new Toast(getContext());
            ImageView image = new ImageView(getContext());

            image.setImageResource(getImageId("silvermed"));
            ImageToast.setView(image);
            ImageToast.setDuration(Toast.LENGTH_LONG);
            ImageToast.show();

            zilver+=1;
        }

        if(score == 180){
            MediaPlayer player;
            player = MediaPlayer.create(getContext(),getAudiofileId("goedgedaan"));
            player.start();
            score += 10;
            tv.setText(s);
            Toast ImageToast = new Toast(getContext());
            ImageView image = new ImageView(getContext());

            image.setImageResource(getImageId("supermedaille1"));
            ImageToast.setView(image);
            ImageToast.setDuration(Toast.LENGTH_LONG);
            ImageToast.show();

            goud+=1;
        }
    }

    public int getAudiofileId(String filename) {
        return getContext().getResources().getIdentifier("raw/" + filename, null, getContext().getPackageName());
    }

    public void setKeuze(int lukraak, int lukr){

        for(int i = 0; i < listGSV.size() ; i++){

            if(listGSV.get(i).getPaar() == listGSV.get(lukraak).getPaar())
                if(listGSV.get(i).getId() != listGSV.get(lukraak).getId()) {
                    if (lukr == 1) {
                        img10.setImageResource(getImageId(listGSV.get(i).getAfbeelding()));
                        img11.setImageResource(getImageId(listGSV.get(lukraak).getAfbeelding()));

                        latestKeuzeLinks = listGSV.get(i).getAfbeelding();
                        latestKeuzeRechts = listGSV.get(lukraak).getAfbeelding();

                    } else {
                        img10.setImageResource(getImageId(listGSV.get(lukraak).getAfbeelding()));
                        img11.setImageResource(getImageId(listGSV.get(i).getAfbeelding()));

                        latestKeuzeRechts = listGSV.get(i).getAfbeelding();
                        latestKeuzeLinks = listGSV.get(lukraak).getAfbeelding();
                    }
                }else
                {
                    for(int b = 0; b < listGSV.size() ; b++){
                        if(listGSV.get(b).getPaar() == listGSV.get(lukraak).getPaar() && listGSV.get(b).getId() != listGSV.get(lukraak).getId()){
                            if (lukr == 1) {
                                img10.setImageResource(getImageId(listGSV.get(b).getAfbeelding()));
                                img11.setImageResource(getImageId(listGSV.get(lukraak).getAfbeelding()));

                                latestKeuzeLinks = listGSV.get(b).getAfbeelding();
                                latestKeuzeRechts = listGSV.get(lukraak).getAfbeelding();
                            } else {
                                img10.setImageResource(getImageId(listGSV.get(lukraak).getAfbeelding()));
                                img11.setImageResource(getImageId(listGSV.get(b).getAfbeelding()));

                                latestKeuzeRechts = listGSV.get(b).getAfbeelding();
                                latestKeuzeLinks = listGSV.get(lukraak).getAfbeelding();
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

        //listGSV.add(new Klank("gat","gat"));
        listGSV.add(new Klank(0,"goud","goud",1));
        listGSV.add(new Klank(1,"fout","tekeningfout",1));
        listGSV.add(new Klank(2,"goed","tekeninggoed",2));
        listGSV.add(new Klank(3,"voet","tekeningvoet",2));
        listGSV.add(new Klank(4,"guus","tekeningguus",3));
        listGSV.add(new Klank(5,"suus","tekeningsuus",3));

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
}
