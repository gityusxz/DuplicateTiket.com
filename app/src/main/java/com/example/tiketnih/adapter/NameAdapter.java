package com.example.tiketnih.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiketnih.R;
import com.example.tiketnih.model.NameAcc;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.CustomViewHolder> {

    private List<NameAcc> dataName;

    private Context context;

    public NameAdapter(List<NameAcc> dataName, Context context){
        this.dataName = dataName;
        this.context = context;
    }

    @NonNull
    @Override
    public NameAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.name_account, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameAdapter.CustomViewHolder holder, int position) {
        holder.txtNameAcc.setText(dataName.get(position).getNamaAcc());
    }

    @Override
    public int getItemCount() {
        return dataName.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View nView;

        TextView txtNameAcc;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            nView = itemView;
            txtNameAcc = nView.findViewById(R.id.textView30);
        }
    }
}
