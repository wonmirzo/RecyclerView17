package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
import com.wonmirzo.listener.OnBottomReachedListener;
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

        List<Member> members = prepareMembers();
        refreshAdapter(members);
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members, new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                Toast.makeText(context, "You have reached bottom of list", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onBottomReached: " + position);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member()); // header

        for (int i = 0; i < 30; i++) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(new Member("Mirzohid " + i, "Dilshodov " + i, false));
            } else {
                members.add(new Member("Mirzohid " + i, "Dilshodov " + i, true));
            }
        }
        members.add(new Member()); // footer
        return members;
    }
}