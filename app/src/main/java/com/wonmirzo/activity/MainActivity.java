package com.wonmirzo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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

        initViews();
        List<Member> members = prepareMembers();
        refreshAdapter(members);
    }

    private void initViews() {
        binding.rvMain.setLayoutManager(new GridLayoutManager(this, 1));
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_from_bottom);
        binding.rvMain.setLayoutAnimation(animation);
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(this, members);
        binding.rvMain.setAdapter(adapter);
    }

    public void openItemDetails(Member member) {
        Toast.makeText(this, member.getFirstName() + " clicked", Toast.LENGTH_SHORT).show();
    }

    private List<Member> prepareMembers() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Mirzohid " + i, "Dilshodov " + i));
        }

        return members;
    }
}