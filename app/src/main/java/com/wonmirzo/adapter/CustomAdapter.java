package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.listener.OnEndReached;
import com.wonmirzo.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    private Context context;
    private final List<Member> members;
    private final OnEndReached onEndReached;

    public CustomAdapter(Context context, List<Member> members, OnEndReached onEndReached) {
        this.members = members;
        this.onEndReached = onEndReached;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (position == members.size() - 1){
            onEndReached.onEndReached(position);
        }

        if (holder instanceof CustomViewHolder) {
            TextView firstName = ((CustomViewHolder) holder).firstName;
            TextView lastName = ((CustomViewHolder) holder).lastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    //holders here
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            firstName = view.findViewById(R.id.tv_first_name);
            lastName = view.findViewById(R.id.tv_last_name);
        }
    }
}
