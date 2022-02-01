package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
import com.wonmirzo.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        nestedScrollView = findViewById(R.id.nested_scroll_view);
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter customAdapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(customAdapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzohid " + i, "Dilshodov " + i));
        }

        return members;
    }


}