package com.example.eoins.judoirelandgrading.adapter;

/**
 * created by Eoin on 30-10-15
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.eoins.judoirelandgrading.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class White extends Fragment {
    int counter = 0;

    LinkedHashMap<String, List<String>> Judo_category;
    List<String> judoMoves;
    ExpandableListView Exp_list;
    JudoAdapter adapter;
    private static final String LOG_TAG = "JudoIrelandGrading";

    public White() {

    }

    public static LinkedHashMap<String, List<String>> getInfo() {


        LinkedHashMap<String, List<String>> JudoMoves = new LinkedHashMap<>();
        List<String> Ukemi = new ArrayList<>();
        Ukemi.add("Backward Fall");
        Ukemi.add("Side Fall");
        Ukemi.add("Backward Roll");

        List<String> NagaWaza = new ArrayList<>();
        NagaWaza.add("De Ashi Barai");
        NagaWaza.add("Hiza Guruma");
        NagaWaza.add("Uki Goshi");
        NagaWaza.add("Sasae Tsurakomi Ashi");

        List<String> OsaekomiWaza = new ArrayList<>();
        OsaekomiWaza.add("Mune Getame");
        OsaekomiWaza.add("Kesa Getame");
        OsaekomiWaza.add("Kami Shiho Getame");

        List<String> Terminology = new ArrayList<>();
        Terminology.add("Hajime");
        Terminology.add("Matte");
        Terminology.add("Sore Made");
        Terminology.add("Sensei");
        Terminology.add("Rei");
        Terminology.add("Dojo");

        JudoMoves.put("Ukemi", Ukemi);
        JudoMoves.put("Naga Waza (Throwing Techniques)", NagaWaza);
        JudoMoves.put("Osaekomi Waza (Holding Techniques)", OsaekomiWaza);
        JudoMoves.put("Terminology", Terminology);

        return JudoMoves;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.white, container, false);
        Exp_list = (ExpandableListView) rootView.findViewById(R.id.exp_list);
        Judo_category = White.getInfo();
        judoMoves = new ArrayList<String>(Judo_category.keySet());
        adapter = new JudoAdapter(getActivity(), Judo_category, judoMoves);
        Exp_list.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}