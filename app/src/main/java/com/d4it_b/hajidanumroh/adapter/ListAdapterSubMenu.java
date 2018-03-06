package com.d4it_b.hajidanumroh.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M N D on 23/02/2018.
 */

public class ListAdapterSubMenu extends RecyclerView.Adapter<ListAdapterSubMenu.ViewHolder>{
    List<SubMenuContent> dataContent= new ArrayList<>();

    ContentListener contentListener;


    public ListAdapterSubMenu(ContentListener listener) {
        this.contentListener = listener;
    }

    public void setData(ArrayList<SubMenuContent> data){
        dataContent=data;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_content, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SubMenuContent content = dataContent.get(position);
        holder.textView.setText(content.getStrContent());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentListener.viewItem(content);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataContent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        public ViewHolder(View itemView) {

            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            textView = (TextView)itemView.findViewById(R.id.text_content);
        }
    }

    public interface ContentListener {
        void viewItem(SubMenuContent content);
    }
}
