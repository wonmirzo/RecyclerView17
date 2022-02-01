package com.wonmirzo.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.activity.MainActivity;
import com.wonmirzo.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    private MainActivity activity;
    private List<Member> members;

    public CustomAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false) ;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof MyViewHolder) {
            TextView firstName = ((MyViewHolder) holder).tvFirstName;
            TextView lastName = ((MyViewHolder) holder).tvLastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    // my holder

    private class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvFirstName, tvLastName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            tvFirstName = view.findViewById(R.id.tv_first_name);
            tvLastName = view.findViewById(R.id.tv_last_name);
        }
    }
}
