package com.d4it_b.hajidanumroh.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.d4it_b.hajidanumroh.DetailActivity;
import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.adapter.ExpandableListAdapter;
import com.d4it_b.hajidanumroh.db.DBHandler;
import com.d4it_b.hajidanumroh.db.DbQueries;
import com.d4it_b.hajidanumroh.model.ContentDetailAct;
import com.d4it_b.hajidanumroh.model.ContentSubMenu;

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

//    List<ContentSubMenu> subMenuContents;
    List<ContentSubMenu> listDataHeader;
    List<ContentDetailAct> contentDetailActs;
    HashMap<ContentSubMenu, List<ContentSubMenu>> listDataChild;
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
        listDataChild = new HashMap<ContentSubMenu, List<ContentSubMenu>>();
        listDataHeader = new ArrayList<ContentSubMenu>();
        listAdapter = new ExpandableListAdapter(getActivity());

        dbHandler = new DBHandler(getActivity());
        dbQueries = new DbQueries(getActivity().getApplicationContext());

        dbQueries.open();

        listDataHeader = dbQueries.getGroup(indexMain);


        contentDetailActs = new ArrayList<>();

        for (ContentSubMenu contentSubMenu : listDataHeader){
            List<ContentSubMenu> tem = dbQueries.getChild(contentSubMenu.getId());
            dbQueries.open();
            listDataChild.put(contentSubMenu,tem);
        }


//            subMenuContents = dbQueries.getAllSubMenu(indexMain);
//        subMenuContents = dbQueries.getAllSubMenu(indexMain);
//
//        for (SubMenuContent subMenuContent : subMenuContents){
//            List<DetailContent> detailContents = new ArrayList<>();
//            dbQueries.open();
//            detailContents = dbQueries.getAllDetailContent(subMenuContent.getIdSubMenu());
//            listDataHeader.add(subMenuContent);
//            listDataChild.put(subMenuContent, detailContents);
//        }



        listAdapter.setData(listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        Log.i("hahahahaa", "onCreateView: "+listAdapter.getGroupCount());

//        click group
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(listAdapter.getChildrenCount(groupPosition) == 0){
                    saveSelectedTabIndex(indexMain);
                    dbQueries.open();
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("idData", listAdapter.getIdGroup(groupPosition));
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
                saveSelectedTabIndex(indexMain);
                dbQueries.open();
                if(dbQueries.getTextIsiDetailContent(listAdapter.getIdChild(groupPosition, childPosition)).size()!=0){
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("idData", listAdapter.getIdChild(groupPosition, childPosition));
                    intent.putExtra("isSetIsi", 1);
                    intent.putExtra("idTitle", listAdapter.getIdGroup(groupPosition));
                    intent.putExtra("title", listAdapter.getChild(groupPosition,childPosition).toString());
                    startActivity(intent);
                }
                return false;
            }
        });
        return view;
    }

    //seve selected tab on shared preference
    public void saveSelectedTabIndex(int selectedIndex){

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("SELECTED_TAB", selectedIndex);
        editor.commit();
    }

}
