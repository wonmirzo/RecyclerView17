package com.wonmirzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wonmirzo.R;
import com.wonmirzo.model.Message;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    private static final int TYPE_CONNECTED = 1;
    private static final int TYPE_NOT_CONNECTED = 0;

    private Context context;
    private List<Message> messageList;

    public MainAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        if (message.isConnected()) {
            return TYPE_CONNECTED;
        }
        return TYPE_NOT_CONNECTED;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONNECTED) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_connected, parent, false);
            return new ViewHolderConnected(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_not_connected, parent, false);
        return new ViewHolderNotConnected(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);

        if (holder instanceof ViewHolderConnected) {
            TextView sendersName = ((ViewHolderConnected) holder).tvSendersName;
            TextView messageTxt = ((ViewHolderConnected) holder).tvMessage;
            TextView date = ((ViewHolderConnected) holder).tvDate;

            sendersName.setText(message.getSendersName());
            messageTxt.setText(message.getMessage());
            date.setText(message.getDate());
        }

        if (holder instanceof ViewHolderNotConnected) {
            TextView sendersName = ((ViewHolderNotConnected) holder).tvSendersName;
            TextView messageTxt = ((ViewHolderNotConnected) holder).tvMessage;
            TextView date = ((ViewHolderNotConnected) holder).tvDate;
        }
    }

    public class ViewHolderConnected extends RecyclerView.ViewHolder {
        View view;
        TextView tvSendersName, tvMessage, tvDate;

        public ViewHolderConnected(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            tvSendersName = view.findViewById(R.id.tv_senders_name);
            tvMessage = view.findViewById(R.id.tv_message);
            tvDate = view.findViewById(R.id.tv_date);
        }
    }

    public class ViewHolderNotConnected extends RecyclerView.ViewHolder {
        View view;
        TextView tvSendersName, tvMessage, tvDate;

        public ViewHolderNotConnected(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            tvSendersName = view.findViewById(R.id.tv_senders_name);
            tvMessage = view.findViewById(R.id.tv_message);
            tvDate = view.findViewById(R.id.tv_date);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
