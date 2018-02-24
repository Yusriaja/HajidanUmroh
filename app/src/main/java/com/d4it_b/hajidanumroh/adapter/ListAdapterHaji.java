package com.d4it_b.hajidanumroh.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.model.haji.Haji;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M N D on 23/02/2018.
 */

public class ListAdapterHaji extends RecyclerView.Adapter<ListAdapterHaji.ViewHolder>{
    List<Haji> dataHaji= new ArrayList<>();

    ListenerHaji listenerHaji;


    public ListAdapterHaji(ListenerHaji listener) {
        this.listenerHaji = listener;
    }

    public void setData(ArrayList<Haji> data){
        dataHaji=data;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_haji, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Haji haji = dataHaji.get(position);
        holder.textView.setText(haji.getString_haji());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerHaji.viewItem(haji);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHaji.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        public ViewHolder(View itemView) {

            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            textView = (TextView)itemView.findViewById(R.id.text_haji);
        }
    }

    public interface ListenerHaji {
        void viewItem(Haji haji);
    }
}
