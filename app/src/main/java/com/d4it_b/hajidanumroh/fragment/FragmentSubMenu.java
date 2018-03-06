package com.d4it_b.hajidanumroh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.d4it_b.hajidanumroh.DBHandler;
import com.d4it_b.hajidanumroh.DetailHajiActivity;
import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.adapter.ExpandableListAdapter;
import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FragmentSubMenu extends Fragment{

    public DBHandler dbHandler;
    public int indexMain;

    List<SubMenuContent> subMenuContents;
    List<String> listDataHeader;
    HashMap<String, List<DetailContent>> listDataChild;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    public FragmentSubMenu() {
        // Required empty public constructor
    }

    public void setIndexMain(int indexMain) {
        this.indexMain= indexMain;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_menu, container, false);
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        listDataChild = new HashMap<String, List<DetailContent>>();
        listDataHeader = new ArrayList<String>();
        subMenuContents = new ArrayList<>();
        listAdapter = new ExpandableListAdapter(getActivity());

        dbHandler = new DBHandler(getActivity());
        subMenuContents = dbHandler.getAllSubMenu(indexMain);

        for (SubMenuContent subMenuContent : subMenuContents){
            List<DetailContent> detailContents = new ArrayList<>();
            detailContents = dbHandler.getAllDetailContent(subMenuContent.getIdSubMenu());
            listDataHeader.add(subMenuContent.getStr_());
            listDataChild.put(subMenuContent.getStr_(), detailContents);
        }

        listAdapter.setData(listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Intent intent = new Intent(getActivity(), DetailHajiActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return view;
    }

}
