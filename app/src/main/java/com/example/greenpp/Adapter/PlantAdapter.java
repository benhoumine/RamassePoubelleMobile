package com.example.greenpp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Entities.Plante;
import com.example.greenpp.Fragments.Charts;
import com.example.greenpp.R;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private List<Plante> plantes;
    private MainActivity context;

    public PlantAdapter(MainActivity context, List<Plante> plantes) {
        this.context = context;
        this.plantes = plantes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.plant_item, viewGroup, false);

        return new ViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Plante plante = plantes.get(i);
        viewHolder.delete.setImageResource(R.drawable.close);
        viewHolder.textViewTitle.setText(plante.getNomPlante());
        viewHolder.textViewBody.setText(plante.getCaractertique());
        String Descrption = plante.getTypePlante() + " " + plante.getCaractertique();
    }

    @Override
    public int getItemCount() {
        return plantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewBody;
        public ImageView delete;

        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            textViewTitle = view.findViewById(R.id.textViewTitle);
            textViewBody = view.findViewById(R.id.textViewBody);
            delete = view.findViewById(R.id.close);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Plante plante = plantes.get(position);
                        Charts chart = Charts.newInstance();
                        chart.getArguments().putString("plante", plante.getNomPlante());
                        context.navigateTo(chart);
                    }
                }
            });
        }
    }
    public void addAllItems(List<Plante> plantes) {
        this.plantes = plantes;
        notifyDataSetChanged();
    }

}
