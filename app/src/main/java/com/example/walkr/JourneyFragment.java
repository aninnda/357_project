package com.example.walkr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JourneyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // We removed the old findViewById logic because your new XML
        // dashboard handles the gamified UI statically for the prototype.
        // This prevents the NullPointerException crash.

        return inflater.inflate(R.layout.fragment_journey, container, false);
    }
}