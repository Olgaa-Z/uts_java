package com.example.LittlebitDonuttt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AyamAdapter extends RecyclerView.Adapter<AyamAdapter.AyamViewHolder> {

    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    private ArrayList<Ayam> ayamArrayList;
    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public AyamAdapter(ArrayList<Ayam> ayamArrayList) {
        this.ayamArrayList = ayamArrayList;
    }

    @NonNull
    @Override
    public AyamAdapter.AyamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new AyamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyamAdapter.AyamViewHolder holder, int position) {
        holder.title.setText(ayamArrayList.get(position).getTitle());
        holder.image.setImageResource(ayamArrayList.get(position).getImage());
        holder.harga.setText(String.valueOf(ayamArrayList.get(position).getHarga()));
    }

    @Override
    public int getItemCount() {
        return (ayamArrayList != null) ? ayamArrayList.size() : 0;
    }

    public class AyamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, harga;
        private ImageView image;

        public AyamViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            harga = (TextView) itemView.findViewById(R.id.harga);
            image = (ImageView) itemView.findViewById(R.id.image);

            itemView.setTag(this);
            itemView.setOnClickListener(this);
            title.setOnClickListener(this);
            harga.setOnClickListener(this);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
