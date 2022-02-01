package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.provider.Settings.Secure;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
import com.wonmirzo.listener.OnBottomReachedListener;
import com.wonmirzo.model.Member;
import com.wonmirzo.model.MemberSub;

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
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members, new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                Toast.makeText(context, "You have reached bottom of list", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            if (i == 1 || i == 10) {
                members.add(new Member("Mirzohid " + i, "Dilshodov " + i, prepareSubMembers()));
            } else {
                members.add(new Member("Mirzohid " + i, "Dilshodov " + i, null));
            }
        }

        return  members;
    }

    private List<MemberSub> prepareSubMembers() {
        List<MemberSub> members = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            members.add(new MemberSub());
        }

        return members;
    }
}