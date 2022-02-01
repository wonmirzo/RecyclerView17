package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.model.Member;
import com.wonmirzo.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<MemberSub> memberSubs;

    public CustomSubAdapter(Context context, List<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub, parent, false);
        return new CustomSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MemberSub memberSub = memberSubs.get(position);

    }

    public class CustomSubViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public CustomSubViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }
}
