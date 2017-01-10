package com.example.androidsp.appgplx.BtnBienBao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidsp.appgplx.R;

import java.util.ArrayList;

/**
 * Created by Androidsp on 23/12/2016.
 */

public class AdapterBienBao extends BaseAdapter {

    private ArrayList<ObjBienbao> listBienbao;
    private Context context;
    private int resource;


    public AdapterBienBao(Context context, int resource, ArrayList<ObjBienbao> listBienbao) {
        this.context = context;
        this.resource = resource;
        this.listBienbao = listBienbao;

    }

    @Override
    public int getCount() {
        return listBienbao.size();
    }

    @Override
    public Object getItem(int position) {
        return listBienbao;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        private ImageView img_traffic;
        private TextView tvName, tvNote;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_bienbao, parent, false);
            mViewHolder.img_traffic = (ImageView) convertView.findViewById(R.id.img_traffic);
            mViewHolder.tvName = (TextView) convertView.findViewById(R.id.txtvName);
            mViewHolder.tvNote = (TextView) convertView.findViewById(R.id.txtvNote);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }


        //Glide.with(context).load("file:///android_asset/imgbienbao/" + listBienbao.get(position).getTenBienbao()+".png").fitCenter().into(mViewHolder.img_traffic);
        mViewHolder.img_traffic.setImageResource(listBienbao.get(position).getLinkanh());
        mViewHolder.tvName.setText(listBienbao.get(position).getTenBienbao());
        mViewHolder.tvNote.setText(listBienbao.get(position).getMoTa());

        return convertView;
    }
}
