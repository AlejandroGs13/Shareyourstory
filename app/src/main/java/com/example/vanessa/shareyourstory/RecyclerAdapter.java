package com.example.vanessa.shareyourstory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Escolar on 25/05/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private String[] Data;
    private ArrayList IDs;
    private int position1=0;


    public RecyclerAdapter(ArrayList IDs){
        this.IDs = IDs;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlista,parent,false);

        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        position1 = position;
        holder.textView.setText(String.valueOf(IDs.get(position)));

    }

    @Override
    public int getItemCount() {
        return IDs.size();
    }



    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ViewHolder(View itemView){
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item);

        }
    }
}

