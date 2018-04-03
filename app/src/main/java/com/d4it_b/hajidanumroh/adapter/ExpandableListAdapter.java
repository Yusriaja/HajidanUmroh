package com.d4it_b.hajidanumroh.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.model.ContentSubMenu;

import java.util.HashMap;
import java.util.List;

/**
 * Created by M N D on 06/03/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<ContentSubMenu> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<ContentSubMenu, List<ContentSubMenu>> _listDataChild;

    public ExpandableListAdapter(Context context) {
        this._context = context;
    }

    public void setData(List<ContentSubMenu> listDataHeader, HashMap<ContentSubMenu, List<ContentSubMenu>> listChildData){
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        notifyDataSetChanged();
    }

    public int getIdChild (int groupPosition, int childPosititon){
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon).getId();
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon).getStr_();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lbl_list_child);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }


    public int getIdGroup(int groupPsotion){
        return this._listDataHeader.get(groupPsotion).getId();
    }
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition).getStr_();
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_list_item, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lbl_list_group);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
