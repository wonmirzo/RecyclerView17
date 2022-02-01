package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.activity.MainActivity;
import com.wonmirzo.model.Member;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private MainActivity activity;
    private List<Member> members;

    public RecyclerViewAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof MyViewHolder) {
            LinearLayout layClick = ((MyViewHolder) holder).layClick;
            TextView tvFirstName = ((MyViewHolder) holder).tvFirstName;
            TextView tvLastName = ((MyViewHolder) holder).tvLastName;

            tvFirstName.setText(member.getFirstName());
            tvLastName.setText(member.getLastName());

            layClick.setOnClickListener((v) -> {
                activity.openItemDetails(member);
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvFirstName, tvLastName;
        LinearLayout layClick;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            tvFirstName = view.findViewById(R.id.tv_first_name);
            tvLastName = view.findViewById(R.id.tv_last_name);
            layClick = view.findViewById(R.id.lay_click);
        }
    }
}
