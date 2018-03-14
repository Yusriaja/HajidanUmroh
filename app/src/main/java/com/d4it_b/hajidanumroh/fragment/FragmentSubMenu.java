package com.d4it_b.hajidanumroh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.d4it_b.hajidanumroh.DetailActivity;
import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.adapter.ExpandableListAdapter;
import com.d4it_b.hajidanumroh.db.DBHandler;
import com.d4it_b.hajidanumroh.db.DbQueries;
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
    List<SubMenuContent> listDataHeader;
    HashMap<SubMenuContent, List<DetailContent>> listDataChild;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    DbQueries dbQueries;

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
        listDataChild = new HashMap<SubMenuContent, List<DetailContent>>();
        listDataHeader = new ArrayList<SubMenuContent>();
        subMenuContents = new ArrayList<>();
        listAdapter = new ExpandableListAdapter(getActivity());

        dbHandler = new DBHandler(getActivity());
        dbQueries = new DbQueries(getActivity().getApplicationContext());

        dbQueries.open();

        subMenuContents = dbQueries.getAllSubMenu(indexMain);

        for (SubMenuContent subMenuContent : subMenuContents){
            List<DetailContent> detailContents = new ArrayList<>();
            dbQueries.open();
            detailContents = dbQueries.getAllDetailContent(subMenuContent.getIdSubMenu());
            listDataHeader.add(subMenuContent);
            listDataChild.put(subMenuContent, detailContents);
        }


        listAdapter.setData(listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

//        click group
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(listAdapter.getChildrenCount(groupPosition) == 0){
                    dbQueries.open();
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("data",dbQueries.getTextDetailContent(listAdapter.getIdGroup(groupPosition)));
                    intent.putExtra("isSetIsi", 0);
                    intent.putExtra("idTitle", indexMain);
                    intent.putExtra("title", listAdapter.getGroup(groupPosition).toString());
                    startActivity(intent);
                }
                return false;
            }
        });

//        click child
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                dbQueries.open();
                if(dbQueries.getTextIsiDetailContent(listAdapter.getIdChild(groupPosition, childPosition)).size()!=0){
                    intent.putExtra("data", dbQueries.getTextIsiDetailContent(listAdapter.getIdChild(groupPosition, childPosition)));
                    intent.putExtra("isSetIsi", 1);
                    intent.putExtra("idTitle", listAdapter.getIdGroup(groupPosition));
                    intent.putExtra("title", listAdapter.getChild(groupPosition,childPosition).toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(), "Sorry", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return view;
    }

}
