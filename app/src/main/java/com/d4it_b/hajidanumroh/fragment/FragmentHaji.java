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
import com.d4it_b.hajidanumroh.adapter.ListAdapterHaji;
import com.d4it_b.hajidanumroh.model.haji.Haji;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FragmentHaji extends Fragment implements ListAdapterHaji.ListenerHaji{

    public ListAdapterHaji listAdapterHaji;
    public DBHandler dbHandler;
    public RecyclerView recyclerView;
    public FragmentHaji() {
        // Required empty public constructor
    }

    Detail me;

    public void setDetail(Detail you) {

        me = you;

    }

    public interface Detail {
        void detail(Haji haji);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_haji, container, false);

        listAdapterHaji = new ListAdapterHaji(this);
        dbHandler = new DBHandler(getActivity());
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_haji);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        if(!dbHandler.isHajiEmpty())
            listAdapterHaji.setData(dbHandler.getAllHaji());
        recyclerView.setAdapter(listAdapterHaji);
        Log.i("Asus", "onCreateView: " + listAdapterHaji.getItemCount());
        return view;
    }
    @Override
    public void viewItem(Haji haji) {
        me.detail(haji);
    }
}
