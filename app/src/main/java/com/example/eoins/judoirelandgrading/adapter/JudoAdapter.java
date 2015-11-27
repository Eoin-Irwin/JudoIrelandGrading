package com.example.eoins.judoirelandgrading.adapter;

/**
 * created by Eoin on 30-10-15
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.eoins.judoirelandgrading.R;

import java.util.HashMap;
import java.util.List;

public class JudoAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    //Categories (Ukemi, Naga Waza, Osaekomi Waza etc)
    private HashMap<String, List<String>> Judo_category;
    //Moves (Ukemi, Naga Waza, Osaekomi Waza etc)
    private List<String> judoMoves;


    public JudoAdapter(Context ctx, HashMap<String, List<String>> Judo_category, List<String> judoMoves) {
        this.ctx = ctx;
        this.Judo_category = Judo_category;
        this.judoMoves = judoMoves;
    }

    @Override
    public Object getChild(int parent, int child) {

        return Judo_category.get(judoMoves.get(parent)).get(child);
    }

    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public int getChildrenCount(int arg0) {

        return Judo_category.get(judoMoves.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {
        return judoMoves.get(arg0);
    }

    @Override
    public int getGroupCount() {
        return judoMoves.size();
    }

    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        String group_title = (String) getGroup(parent);
        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.parent_layout, parentview, false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);

        return convertview;
    }

    @Override
    public View getChildView(final int parent, final int child, boolean lastChild, View convertview, ViewGroup parentview) {
        String child_title = (String) getChild(parent, child);

        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.child_layout, parentview, false);
        }

        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_title);
        return convertview;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}