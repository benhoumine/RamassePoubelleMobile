package com.example.greenpp.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Activities.mapBoxActivity;
import com.example.greenpp.Entities.Poubelle;
import com.example.greenpp.Interfaces.RecyclerViewClickListener;
import com.example.greenpp.R;
import com.google.gson.Gson;

import java.util.List;

public class PoubelleAdapter extends RecyclerView.Adapter<PoubelleAdapter.ViewHolder> {

    private List<Poubelle> poubelles;
    private MainActivity context;
    private static RecyclerViewClickListener itemListener;

    public PoubelleAdapter(MainActivity context, RecyclerViewClickListener itemListener, List<Poubelle> poubelles) {
        this.context = context;
        this.poubelles = poubelles;
        this.itemListener = itemListener;
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
        Poubelle poubelle = poubelles.get(i);
        viewHolder.delete.setImageResource(R.drawable.close);
        viewHolder.textViewTitle.setText(poubelle.getAdresse());
        viewHolder.textViewBody.setText("Capacité : " + poubelle.getCapacity().toString() + "  Contenu : " + poubelle.getContenu().toString());
        // String Descrption = plante.getTypePlante() + " " + plante.getCaractertique();
        if(poubelle.getContenu().intValue()==poubelle.getCapacity().intValue())
            viewHolder.imageView.setImageResource(R.drawable.red);
        else if(poubelle.getContenu()>=poubelle.getCapacity()/2)
            viewHolder.imageView.setImageResource(R.drawable.full);
        else
            viewHolder.imageView.setImageResource(R.drawable.empty);

    }

    @Override
    public int getItemCount() {
        return poubelles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
                        Poubelle poubelle = poubelles.get(position);

                        Gson gson = new Gson();
                        String poubelleJson = gson.toJson(poubelle);

                        Intent intent = new Intent(context, mapBoxActivity.class);
                        intent.putExtra("POUBELLE_JSON", poubelleJson);
                        context.startActivity(intent);
                    }
                }
            });
            //view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getPosition());
        }
    }
    public void addAllItems(List<Poubelle> poubelles) {
        poubelles = poubelles;
        notifyDataSetChanged();
    }

}
