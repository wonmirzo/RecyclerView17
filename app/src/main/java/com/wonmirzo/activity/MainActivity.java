package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.wonmirzo.R;
import com.wonmirzo.adapter.RecyclerViewAdapter;
import com.wonmirzo.databinding.ActivityMainBinding;
import com.wonmirzo.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();

    }

    private void initViews() {
        members = prepareMemberList();
        refreshAdapter(members);

        binding.rvMain.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void refreshAdapter(List<Member> members) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, members);
        binding.rvMain.setAdapter(adapter);
    }

    public void openItemDetails(Member member) {
        Toast.makeText(this, member.getFirstName() + " item has clicked", Toast.LENGTH_SHORT).show();
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzohid " + i, "Dilshodov " + i));
        }

        return members;
    }
}