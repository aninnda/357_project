package com.example.walkr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeaderboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- SARAH CHEN ---
        setupCheerButton(view, R.id.btn_cheer_sarah, R.id.tv_sarah_cheers, "Sarah Chen");

        // --- MARCUS JOHNSON ---
        setupCheerButton(view, R.id.btn_cheer_marcus, R.id.tv_marcus_cheers, "Marcus Johnson");

        // --- EMMA RODRIGUEZ ---
        setupCheerButton(view, R.id.btn_cheer_emma, R.id.tv_emma_cheers, "Emma Rodriguez");

        // --- YOU ---
        setupCheerButton(view, R.id.btn_cheer_user, R.id.tv_user_cheers, "You");
    }

    /**
     * Helper to link a button to a textview and handle the click logic
     */
    private void setupCheerButton(View root, int buttonId, int textId, String name) {
        Button btn = root.findViewById(buttonId);
        TextView tv = root.findViewById(textId);

        if (btn != null && tv != null) {
            btn.setOnClickListener(v -> {
                String currentText = tv.getText().toString();
                // Extract digits only
                String numberOnly = currentText.replaceAll("[^0-9]", "");

                try {
                    int newCount = Integer.parseInt(numberOnly) + 1;
                    tv.setText(name + "  ❤️ " + newCount);

                    // Optional: Disable button so they only cheer once per session
                    v.setEnabled(false);
                    ((Button)v).setText("Cheered!");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}