package com.example.dipes.internshipchallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<PostData> data;
    DataAdapter(ArrayList<PostData> android) {
        this.data = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.Id.setText(data.get(position).getId());
        holder.Body.setText(data.get(position).getBody());
        holder.Title.setText(data.get(position).getTitle().toUpperCase());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Id;
        private TextView Title;
        private TextView Body;

        public ViewHolder(View itemView) {
            super(itemView);
            Id = (TextView)itemView.findViewById(R.id.Id);
            Title = (TextView)itemView.findViewById(R.id.Title);
            Body = (TextView)itemView.findViewById(R.id.Body);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "inside viewholder position = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();



                }
            });
        }
    }
}
