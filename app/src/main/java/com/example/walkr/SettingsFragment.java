package com.example.walkr;

import android.content.Context;
import android.content.SharedPreferences;
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

        CardView cardSahara = view.findViewById(R.id.card_sahara);
        CardView cardEverest = view.findViewById(R.id.card_everest);
        ImageView checkSahara = view.findViewById(R.id.check_sahara);
        ImageView checkEverest = view.findViewById(R.id.check_everest);

        if (cardSahara != null && checkSahara != null && cardEverest != null && checkEverest != null) {

            // Get the shared preferences database
            SharedPreferences prefs = requireActivity().getSharedPreferences("WalkrPrefs", Context.MODE_PRIVATE);

            // Set initial state based on saved preferences (so it remembers when you reopen the app)
            String activeJourney = prefs.getString("active_journey", "everest");
            if (activeJourney.equals("sahara")) {
                checkSahara.setVisibility(View.VISIBLE);
                checkEverest.setVisibility(View.GONE);
            } else {
                checkEverest.setVisibility(View.VISIBLE);
                checkSahara.setVisibility(View.GONE);
            }

            cardSahara.setOnClickListener(v -> {
                checkSahara.setVisibility(View.VISIBLE);
                checkEverest.setVisibility(View.GONE);
                // Save "sahara" to preferences
                prefs.edit().putString("active_journey", "sahara").apply();
            });

            cardEverest.setOnClickListener(v -> {
                checkEverest.setVisibility(View.VISIBLE);
                checkSahara.setVisibility(View.GONE);
                // Save "everest" to preferences
                prefs.edit().putString("active_journey", "everest").apply();
            });

        } else {
            android.util.Log.e("SettingsFragment", "One or more views were NOT found. Check your XML IDs!");
        }
    }
}