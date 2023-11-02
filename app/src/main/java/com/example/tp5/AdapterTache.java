package com.example.tp5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp5.databinding.ItemBinding;

import java.util.ArrayList;

public class AdapterTache extends RecyclerView.Adapter<AdapterTache.ViewHolderTache> {
    ArrayList<Tache> taches = new ArrayList<>();
    Context context;

    public AdapterTache(ArrayList<Tache> L){
        this.taches = L;
    }
    @NonNull
    @Override
    public ViewHolderTache onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolderTache(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTache holder, int position) {
        Tache t = taches.get(position);
        holder.setTache(t);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsTache.class);
                intent.putExtra("name",t.getTachename());
                intent.putExtra("jour",t.getTachejour());
                intent.putExtra("time",t.getTachetime());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return taches.size();
    }

    public class ViewHolderTache extends RecyclerView.ViewHolder {
        ItemBinding ui;
        public ViewHolderTache(@NonNull ItemBinding ui){
            super(ui.getRoot());
            this.ui = ui;
        }
        void setTache(Tache t){
            ui.nameTache.setText(t.getTachename());
            ui.jourTache.setText(t.getTachejour());
            ui.timeTache.setText(t.getTachetime());
        }
    }
}
