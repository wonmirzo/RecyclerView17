package com.wonmirzo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            LinearLayout llCustom = ((CustomViewHolder) holder).llCustom;
            TextView tvFirstName = ((CustomViewHolder) holder).tvFirstName;
            TextView tvLastName = ((CustomViewHolder) holder).tvLastName;

            tvFirstName.setText(member.getFirstName());
            tvLastName.setText(member.getLastName());

            llCustom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.openItemDetails(member);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    // holder

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvFirstName, tvLastName;
        LinearLayout llCustom;
        RelativeLayout view_background, view_foreground;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            llCustom = view.findViewById(R.id.ll_custom);
            tvFirstName = view.findViewById(R.id.tv_first_name);
            tvLastName = view.findViewById(R.id.tv_last_name);

            view_background = (RelativeLayout) view.findViewById(view_background);
            view_foreground = (RelativeLayout) view.findViewById(view_foreground);
        }
    }
}
