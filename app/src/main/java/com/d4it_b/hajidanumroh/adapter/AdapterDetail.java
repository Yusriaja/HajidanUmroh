package com.d4it_b.hajidanumroh.adapter;

import android.content.Context;
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

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.ViewHolder>{
    List<String> dataContent= new ArrayList<>();

    ContentListener contentListener;
    Context context;

    public AdapterDetail(Context context) {
        this.context =  context;
    }

    public void setData(List<String> data){
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
        final String content = dataContent.get(position);
        holder.textView.setText(content);
    }

    @Override
    public int getItemCount() {
        return dataContent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text_content);
        }
    }

    public interface ContentListener {
        void viewItem(SubMenuContent content);
    }
}
