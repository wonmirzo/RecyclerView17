package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
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

        if (holder instanceof CustomViewHolder) {
            TextView firstName = ((CustomViewHolder) holder).firstName;
            TextView lastName = ((CustomViewHolder) holder).lastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView firstName, lastName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            firstName = view.findViewById(R.id.tv_first_name);
            lastName = view.findViewById(R.id.tv_last_name);
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
}
