package com.example.androidsp.appgplx.BtnDethi;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidsp.appgplx.R;

import java.util.ArrayList;


public class ItemBoxAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ObjItemBox> list;
    private LayoutInflater inflater;

    public ItemBoxAdapter(Context context, ArrayList<ObjItemBox> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView tv_box;
    }

    @Override
    public View getView(int position, View conterView, ViewGroup viewGroup) {
        View view = conterView;
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_textview_box, viewGroup, false);
            holder = new ViewHolder();
            holder.tv_box = (TextView) view.findViewById(R.id.tv_box);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        switch (list.get(position).getIndexAns()) {
            case 3:
                holder.tv_box.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;

            case 2:
                holder.tv_box.setBackgroundColor(Color.parseColor("#FFF12323"));
                break;

            case 1:
                holder.tv_box.setBackgroundColor(Color.parseColor("#77FF00"));
                break;

            case 4:
                holder.tv_box.setBackgroundColor(Color.parseColor("#FFEB3B"));
                break;
        }

        return view;
    }
}
