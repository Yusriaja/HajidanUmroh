package com.d4it_b.hajidanumroh.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.R;
import com.d4it_b.hajidanumroh.model.ContentDetailAct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M N D on 23/02/2018.
 */

public class AdapterDetail extends BaseAdapter{
    List<ContentDetailAct> dataContent= new ArrayList<>();

//    ContentListener contentListener;
    Context context;

    public AdapterDetail(Context context, ArrayList<ContentDetailAct> data) {
        this.context =  context;
        this.dataContent = data;
    }

//    public void setData(ArrayList<ContentDetailAct> data){
//        dataContent=data;
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return dataContent.size();
    }

    @Override
    public Object getItem(int position) {
        return dataContent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView_text, textView_arab,textView_arti, textView_latin;
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_content, parent,false);
        textView_text= (TextView)convertView.findViewById(R.id.text_content);
        textView_arti= (TextView)convertView.findViewById(R.id.arti_content);
        textView_arab= (TextView)convertView.findViewById(R.id.arab_content);
        textView_latin= (TextView)convertView.findViewById(R.id.latin_content);


        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/Arabtype.ttf");
        textView_arab.setTypeface(tf);


//        ContentDetailAct content = dataContent.get(position);

        if (dataContent.get(position).getArab() != null){
            textView_arab.setText(dataContent.get(position).getArab());
            textView_arab.setVisibility(View.VISIBLE);
        }

        if (dataContent.get(position).getArti() != null){
            textView_arti.setText(dataContent.get(position).getArti());
            textView_arti.setVisibility(View.VISIBLE);
        }

        if (dataContent.get(position).getLatin() != null){
            textView_latin.setText(dataContent.get(position).getLatin());
            textView_latin.setVisibility(View.VISIBLE);
        }
        if (dataContent.get(position).getText()!=null){
            textView_text.setText(dataContent.get(position).getText());
            textView_text.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_content, parent, false);
//        return new ViewHolder(v);
//    }

//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        final ContentDetailAct content = dataContent.get(position);
//
//        if (content.getArab() != null){
//            holder.textView_arab.setText(content.getArab());
//            holder.textView_arab.setVisibility(View.VISIBLE);
//        }
//
//        if (content.getArti() != null){
//            holder.textView_arti.setText(content.getArti());
//            holder.textView_arti.setVisibility(View.VISIBLE);
//        }
//
//        if (content.getLatin() != null){
//            holder.textView_latin.setText(content.getLatin());
//            holder.textView_latin.setVisibility(View.VISIBLE);
//        }
//        if (content.getText()!=null){
//            holder.textView_text.setText(content.getText());
//            holder.textView_text.setVisibility(View.VISIBLE);
//        }
//
//
//    }

//    @Override
//    public int getItemCount() {
//        return dataContent.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textView_text, textView_arab,textView_arti, textView_latin;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            textView_text= (TextView)itemView.findViewById(R.id.text_content);
//            textView_arti= (TextView)itemView.findViewById(R.id.arti_content);
//            textView_arab= (TextView)itemView.findViewById(R.id.arab_content);
//            textView_latin= (TextView)itemView.findViewById(R.id.latin_content);
//        }
//    }

//    public interface ContentListener {
//        void viewItem(SubMenuContent content);
//    }
}
