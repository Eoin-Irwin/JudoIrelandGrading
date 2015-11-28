package com.example.eoins.judoirelandgrading.fragments;

/**
 * created by Eoin on 30-10-15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.eoins.judoirelandgrading.R;
import com.example.eoins.judoirelandgrading.adapter.Brown;
import com.example.eoins.judoirelandgrading.adapter.JudoAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class BlackFragment extends Fragment {
    LinkedHashMap<String, List<String>> Judo_category;
    List<String> judoMoves;
    ExpandableListView Exp_list;
    JudoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.brown, container, false);
        Exp_list = (ExpandableListView) rootView.findViewById(R.id.exp_list);
        Judo_category = Brown.getInfo();
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
