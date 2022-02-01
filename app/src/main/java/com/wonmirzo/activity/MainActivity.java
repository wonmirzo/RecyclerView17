package com.wonmirzo.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
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

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main);
        context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzaolim " + i, "Dilshodo " + i));
        }
        return members;
    }
}