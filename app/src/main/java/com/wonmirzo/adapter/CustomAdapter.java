package com.wonmirzo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.listener.OnBottomReachedListener;
import com.wonmirzo.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM_HEADER = 0;
    private static final int TYPE_ITEM_YES = 1;
    private static final int TYPE_ITEM_NO = 2;
    private static final int TYPE_ITEM_FOOTER = 3;

    private Context context;
    private List<Member> members;
    private OnBottomReachedListener listener;

    public CustomAdapter(Context context, List<Member> members, OnBottomReachedListener listener) {
        this.context = context;
        this.members = members;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;

        Member member = members.get(position);
        if (member.isAvailable()) return TYPE_ITEM_YES;
        return TYPE_ITEM_NO;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }

    private boolean isFooter(int position) {
        return position == members.size() - 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_header_layout, parent,false);
            return new CustomViewHeaderHolder(view);
        }
        if (viewType == TYPE_ITEM_YES) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_yes_layout, parent,false);
            return new CustomViewYesHolder(view);
        }
        if (viewType == TYPE_ITEM_NO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_no_layout, parent,false);
            return new CustomViewNoHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_footer_layout, parent,false);
        return new CustomViewFooterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == members.size() - 1) {
            listener.onBottomReached(position);
        }

        if (isHeader(position) || isFooter(position)) return;

        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder) {
            TextView firstName = ((CustomViewYesHolder) holder).firstName;
            TextView lastName = ((CustomViewYesHolder) holder).lastName;

            firstName.setText(member.getFirstName());
            lastName.setText(member.getLastName());
        }

        if (holder instanceof CustomViewNoHolder) {
            TextView firstName = ((CustomViewNoHolder) holder).firstName;
            TextView lastName = ((CustomViewNoHolder) holder).lastName;

            firstName.setText("No available first name");
            lastName.setText("No available last name");
        }
    }

    public class CustomViewHeaderHolder extends RecyclerView.ViewHolder {
        View view;

        public CustomViewHeaderHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }

    public class CustomViewYesHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;

        public CustomViewYesHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            firstName = view.findViewById(R.id.tv_first_name);
            lastName = view.findViewById(R.id.tv_last_name);
        }
    }

    public class CustomViewNoHolder extends RecyclerView.ViewHolder {
        View view;
        TextView firstName, lastName;

        public CustomViewNoHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            firstName = view.findViewById(R.id.tv_first_name);
            lastName = view.findViewById(R.id.tv_last_name);
        }
    }

    public class CustomViewFooterHolder extends RecyclerView.ViewHolder {
        View view;

        public CustomViewFooterHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
}
