package com.example.walkr;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch; // Make sure this is imported!
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

        // 1. Find the new switches
        Switch switchBeatLeader = view.findViewById(R.id.switch_beat_leader);
        Switch switchInactiveGap = view.findViewById(R.id.switch_inactive_gap);

        if (cardSahara != null && checkSahara != null && cardEverest != null && checkEverest != null) {

            SharedPreferences prefs = requireActivity().getSharedPreferences("WalkrPrefs", Context.MODE_PRIVATE);

            // --- JOURNEY CARDS LOGIC (Unchanged) ---
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
                prefs.edit().putString("active_journey", "sahara").apply();
            });

            cardEverest.setOnClickListener(v -> {
                checkEverest.setVisibility(View.VISIBLE);
                checkSahara.setVisibility(View.GONE);
                prefs.edit().putString("active_journey", "everest").apply();
            });

            // --- SMART REMINDERS LOGIC (New) ---
            if (switchBeatLeader != null && switchInactiveGap != null) {
                // Read the saved states (defaulting to true for leader, false for gap)
                boolean isBeatLeaderOn = prefs.getBoolean("beat_leader", true);
                boolean isInactiveGapOn = prefs.getBoolean("inactive_gap", false);

                // Set the visual switches to match the saved data
                switchBeatLeader.setChecked(isBeatLeaderOn);
                switchInactiveGap.setChecked(isInactiveGapOn);

                // Save the new state instantly whenever the user clicks the toggle
                switchBeatLeader.setOnCheckedChangeListener((buttonView, isChecked) ->
                        prefs.edit().putBoolean("beat_leader", isChecked).apply()
                );

                switchInactiveGap.setOnCheckedChangeListener((buttonView, isChecked) ->
                        prefs.edit().putBoolean("inactive_gap", isChecked).apply()
                );
            }

        } else {
            android.util.Log.e("SettingsFragment", "One or more views were NOT found. Check your XML IDs!");
        }
    }
}