package com.example.walkr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeaderboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // We removed the ListView and ArrayAdapter logic because your
        // new XML layout handles the gamified visual design statically for the prototype.

        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }
}