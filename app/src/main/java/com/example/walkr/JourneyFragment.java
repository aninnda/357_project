package com.example.walkr;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JourneyFragment extends Fragment {

    public JourneyFragment() {
        super(R.layout.fragment_journey);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateUI(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        // This ensures the page refreshes automatically when you click the Journey tab
        if (getView() != null) {
            updateUI(getView());
        }
    }

    private void updateUI(View view) {
        SharedPreferences prefs = requireActivity().getSharedPreferences("WalkrPrefs", Context.MODE_PRIVATE);
        String activeJourney = prefs.getString("active_journey", "everest"); // Everest is the default

        // Find the views
        TextView tvHeaderEmoji = view.findViewById(R.id.tv_header_emoji);
        TextView tvHeaderTitle = view.findViewById(R.id.tv_header_title);
        TextView tvHeaderSubtitle = view.findViewById(R.id.tv_header_subtitle);
        TextView tvCardTitle = view.findViewById(R.id.tv_card_title);
        TextView tvCardSubtitle = view.findViewById(R.id.tv_card_subtitle);
        ImageView ivMainImage = view.findViewById(R.id.iv_main_image);
        TextView tvProgressLine2 = view.findViewById(R.id.tv_progress_line2);
        TextView tvLegend = view.findViewById(R.id.tv_legend);

        // Update them based on the SharedPreferences choice
        if (tvHeaderTitle != null) {
            if (activeJourney.equals("sahara")) {
                tvHeaderEmoji.setText("🏜️ ");
                tvHeaderTitle.setText("Desert Trekker");
                tvHeaderSubtitle.setText("Walk your way across the dunes");
                tvCardTitle.setText("Your Journey across the Sahara");
                tvCardSubtitle.setText("Watch your avatar cross the Sahara Desert as you reach your daily goal");
                ivMainImage.setImageResource(R.drawable.sahara_bg); // Ensure sahara_bg is in your drawable folder
                tvProgressLine2.setText("across the Sahara!");
                tvLegend.setText("Trail across dunes");
            } else {
                tvHeaderEmoji.setText("⛰️ ");
                tvHeaderTitle.setText("Summit Tracker");
                tvHeaderSubtitle.setText("Climb your way to fitness, one step at a time");
                tvCardTitle.setText("Your Journey to the Summit");
                tvCardSubtitle.setText("Watch your avatar climb Mount Everest as you reach your daily goal");
                ivMainImage.setImageResource(R.drawable.mountain_bg);
                tvProgressLine2.setText("up Mt. Everest!");
                tvLegend.setText("Trail to Summit");
            }
        }
    }
}