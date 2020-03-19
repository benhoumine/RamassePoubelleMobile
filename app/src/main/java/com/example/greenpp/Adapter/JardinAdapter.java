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
import com.example.greenpp.Entities.Jardin;
import com.example.greenpp.Interfaces.RecyclerViewClickListener;
import com.example.greenpp.R;
import com.google.gson.Gson;

import java.util.List;

public class JardinAdapter extends RecyclerView.Adapter<JardinAdapter.ViewHolder> {

    private List<Jardin> jardins;
    private MainActivity context;
    private static RecyclerViewClickListener itemListener;

    public JardinAdapter(MainActivity context, RecyclerViewClickListener itemListener, List<Jardin> plantes) {
        this.context = context;
        this.jardins = plantes;
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
        Jardin jardin = jardins.get(i);
        viewHolder.delete.setImageResource(R.drawable.close);
        viewHolder.textViewTitle.setText(jardin.getNomJardin());
        viewHolder.textViewBody.setText("Vide");
        // String Descrption = plante.getTypePlante() + " " + plante.getCaractertique();
    }

    @Override
    public int getItemCount() {
        return jardins.size();
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
                        Jardin jardin = jardins.get(position);

                        Gson gson = new Gson();
                        String jardinJson = gson.toJson(jardin);

                        System.out.println("Le jardin selectionné est : " + jardinJson);
                        Intent intent = new Intent(context, mapBoxActivity.class);
                        intent.putExtra("JARDIN_JSON", jardinJson);
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
    public void addAllItems(List<Jardin> jardins) {
        this.jardins = jardins;
        notifyDataSetChanged();
    }

}
