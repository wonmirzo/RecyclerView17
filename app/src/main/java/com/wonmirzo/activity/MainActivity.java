package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
import com.wonmirzo.listener.OnEndReached;
import com.wonmirzo.model.Member;

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
        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members, new OnEndReached() {
            @Override
            public void onEndReached(int position) {
                Toast.makeText(context, "You have reached end of the list!", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzohid " + i, "Dilshodov " + i));
        }

        return members;
    }


}