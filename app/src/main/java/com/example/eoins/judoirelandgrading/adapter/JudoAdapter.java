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

//This provides data and a view from
// some data to an expandable list view
public class JudoAdapter extends BaseExpandableListAdapter {
    //Activity context
    private Context ctx;
    //Categories (Ukemi, Naga Waza, Osaekomi Waza etc)
    private HashMap<String, List<String>> Judo_category;
    //Moves (Ukemi, Naga Waza, Osaekomi Waza etc)
    private List<String> judoMoves;

    //Adapter which passes the expandable list view
    public JudoAdapter(Context ctx, HashMap<String, List<String>> Judo_category, List<String> judoMoves) {
        this.ctx = ctx;
        this.Judo_category = Judo_category;
        this.judoMoves = judoMoves;
    }

    //Child layout that returns the Category
    //and the moves within them
    @Override
    public Object getChild(int parent, int child) {

        return Judo_category.get(judoMoves.get(parent)).get(child);
    }

    //Gets the ID for the given
    // child within the group.
    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    //Gets the number of children in a specified group
    //In this instance the moves
    @Override
    public int getChildrenCount(int arg0) {

        return Judo_category.get(judoMoves.get(arg0)).size();
    }

    //Gets the data associated with the given group
    @Override
    public Object getGroup(int arg0) {
        return judoMoves.get(arg0);
    }

    //Get the number of groups
    @Override
    public int getGroupCount() {
        return judoMoves.size();
    }

    //Gets the ID for the given
    // child within the group.
    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }

    //Indicates whether the child and group IDs are
    //stable across changes to the underlying data.
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //Gets a View that displays the given group.
    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        String group_title = (String) getGroup(parent);
        if (convertview == null) {
            //Inflates the layout
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //this method creates the parent layout
            convertview = inflater.inflate(R.layout.parent_layout, parentview, false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        //Enbolden the textView
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);

        return convertview;
    }

    //Gets a View that displays the data for
    //the given child within the given group
    @Override
    public View getChildView(final int parent, final int child, boolean lastChild, View convertview, ViewGroup parentview) {
        String child_title = (String) getChild(parent, child);

        if (convertview == null) {
            //Inflates the layout
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //this method creates the parent layout
            convertview = inflater.inflate(R.layout.child_layout, parentview, false);
        }
        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_title);
        return convertview;
    }

    //Whether the childView can be selected or not
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}