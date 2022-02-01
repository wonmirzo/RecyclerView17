package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.wonmirzo.R;
import com.wonmirzo.adapter.MainAdapter;
import com.wonmirzo.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Message> messageList = makeMessage();
        refreshAdapter(messageList);
    }

    private void refreshAdapter(List<Message> messageList) {
        MainAdapter adapter = new MainAdapter(context, messageList);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    private List<Message> makeMessage() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Mirzohid", "Salom qalaysan? Nimalar bilan bandsan?","Wednesday",true));
        messages.add(new Message("Mirzaolim", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n","Today",false));
        messages.add(new Message("Mirzohid", "Salom qalaysan? Nimalar bilan bandsan?","Monday",true));
        messages.add(new Message("Mirzaolim", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n","12.07.2021",false));
        messages.add(new Message("Mirzohid", "Salom qalaysan? Nimalar bilan bandsan?","Thursday",false));
        messages.add(new Message("Mirzaolim", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n","Wednesday",false));
        messages.add(new Message("Mirzohid", "Salom qalaysan? Nimalar bilan bandsan?","Wednesday",true));
        messages.add(new Message("Mirzaolim", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n","21.02.2022",true));
        messages.add(new Message("Mirzohid", "Salom qalaysan? Nimalar bilan bandsan?","Friday",false));

        return messages;
    }
}