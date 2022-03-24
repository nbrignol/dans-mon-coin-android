package fr.nbrignol.dansmoncoin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter implements PoiDaoListener {

    PoiDaoInterface dao;

    RecyclerViewAdapter (){
        dao = new PoiMockDao();
        dao.init(this);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_view_item,
                parent,
                false
        );

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        Poi poi = dao.getPoi(position);
        viewHolder.getTextView().setText(poi.getTitle());
    }

    @Override
    public int getItemCount() {
        return dao.getCount();
    }

    @Override
    public void onDataChanged() {
        //tell the RecyclerView to refresh
        notifyDataSetChanged();

    }
}
