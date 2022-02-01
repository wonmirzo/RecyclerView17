package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.wonmirzo.R;
import com.wonmirzo.adapter.CustomAdapter;
import com.wonmirzo.databinding.ActivityMainBinding;
import com.wonmirzo.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        List<Member> members = prepareMembers();
        refreshAdapter(members);
    }

    private void initView() {
        binding.rvMain.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(this, members);
        binding.rvMain.setAdapter(adapter);
    }

    public void openItemSelected(Member member) {
        Toast.makeText(this, member.getLastName() + " clicked", Toast.LENGTH_SHORT).show();
    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzohid " + i, "Dilshodo " + i));
        }
        return members;
    }
}