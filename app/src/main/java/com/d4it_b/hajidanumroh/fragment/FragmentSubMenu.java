package com.d4it_b.hajidanumroh.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.d4it_b.hajidanumroh.DBHandler;
import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.adapter.ListAdapterSubMenu;
import com.d4it_b.hajidanumroh.model.SubMenuContent;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FragmentSubMenu extends Fragment implements ListAdapterSubMenu.ContentListener{

    public ListAdapterSubMenu listAdapterSubMenu;
    public DBHandler dbHandler;
    public RecyclerView recyclerView;
    public String tableName="tb_haji";
    public FragmentSubMenu() {
        // Required empty public constructor
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_menu, container, false);

        listAdapterSubMenu = new ListAdapterSubMenu(this);
        dbHandler = new DBHandler(getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_haji);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        if(!dbHandler.isHajiEmpty())
        listAdapterSubMenu.setData(dbHandler.getAll(tableName));
        recyclerView.setAdapter(listAdapterSubMenu);
        Log.i("Asus", "onCreateView: " + listAdapterSubMenu.getItemCount());
        return view;
    }
    @Override
    public void viewItem(SubMenuContent content) {
        me.detail(content);
    }

    Detail me;

    public void setDetail(Detail you) {

        me = you;

    }

    public interface Detail {
        void detail(SubMenuContent content);
    }
}
