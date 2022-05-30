package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecviewAdapter extends RecyclerView.Adapter<RecviewAdapter.RecviewViewHolder> {
    private String[] dataset;

    public RecviewAdapter(String[] dataset){
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout itemLayout = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_item,parent,false);
        RecviewViewHolder recviewViewHolder = new RecviewViewHolder(itemLayout);
        return recviewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewViewHolder holder, int position) {
        holder.textView.setText(dataset[position]);
        holder.button.setText("Press");
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    public class RecviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public Button button;
        public RecviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            button = itemView.findViewById(R.id.button);
            //textView.setOnClickListener(this);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Something pressed"+textView.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
