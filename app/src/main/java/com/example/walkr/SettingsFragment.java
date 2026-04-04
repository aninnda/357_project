package com.example.walkr;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        super(R.layout.fragment_settings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // MATCHING THE XML: Using standard CardView here
        CardView cardSahara = view.findViewById(R.id.card_sahara);
        CardView cardEverest = view.findViewById(R.id.card_everest);
        ImageView checkSahara = view.findViewById(R.id.check_sahara);
        ImageView checkEverest = view.findViewById(R.id.check_everest);

        // Only set listeners if the views were actually found
        if (cardSahara != null && checkSahara != null && cardEverest != null && checkEverest != null) {

            cardSahara.setOnClickListener(v -> {
                // Standard CardViews don't have stroke borders, so we just toggle the checkmarks
                checkSahara.setVisibility(View.VISIBLE);
                checkEverest.setVisibility(View.GONE);
            });

            cardEverest.setOnClickListener(v -> {
                checkEverest.setVisibility(View.VISIBLE);
                checkSahara.setVisibility(View.GONE);
            });

        } else {
            android.util.Log.e("SettingsFragment", "One or more views were NOT found. Check your XML IDs!");
        }
    }
}