package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.listener.OnBottomReachedListener;
import com.wonmirzo.model.Member;
import com.wonmirzo.model.MemberSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

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
        Member member = members.get(position);

        if (member.getMemberSubs() != null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list, parent, false);
            return new CustomListHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == members.size() - 1) {
            listener.onBottomReached(position);
        }

        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView textView = ((CustomViewHolder) holder).textView;

            textView.setText(member.getFirstName());
        }
        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdapter(recyclerView, memberSubs);
        }
    }

    private void refreshSubAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs) {
        CustomSubAdapter adapter = new CustomSubAdapter(context, memberSubs);
        recyclerView.setAdapter(adapter);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            textView = view.findViewById(R.id.tv_view_text);
        }
    }

    public class CustomListHolder extends RecyclerView.ViewHolder {
        View view;
        RecyclerView recyclerView;

        public CustomListHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            recyclerView = view.findViewById(R.id.rv_sub);
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
}
