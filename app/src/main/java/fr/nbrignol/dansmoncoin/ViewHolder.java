package fr.nbrignol.dansmoncoin;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.theTextView);
    }

    public TextView getTextView() {
        return textView;
    }

}
