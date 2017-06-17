package com.example.laptop.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsAdapter extends ArrayAdapter<Custom> {

    public NewsAdapter(Context context, ArrayList<Custom> newsArrayList) {
        super(context, 0, newsArrayList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Custom abc = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView sxnName = (TextView) convertView.findViewById(R.id.id1);
        TextView  WebPubDate= (TextView) convertView.findViewById(R.id.id2);
        TextView WebTitle=(TextView) convertView.findViewById(R.id.id3);
        sxnName.setText(abc.getWebTitle());
        WebPubDate.setText(abc.getSectionName());
        WebTitle.setText(abc.getWebpblDate());
        return convertView;
    }
}
