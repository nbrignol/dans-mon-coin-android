package fr.nbrignol.dansmoncoin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    List<String> dataList;

    RecyclerViewAdapter(){
        dataList = new ArrayList<String>();
        dataList.add("Le super portail de l'IUT");
        dataList.add("Le batiment \"informatique\"");
        dataList.add("Le resto-U");
        dataList.add("Un autre");
        dataList.add("Encore un autre");
        dataList.add("Et encore un autre");
        dataList.add("Le dernier");
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
        viewHolder.getTextView().setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
