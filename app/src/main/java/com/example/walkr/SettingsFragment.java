public class SettingsFragment extends Fragment {

    private MaterialCardView cardSahara;
    private MaterialCardView cardEverest;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardSahara = view.findViewById(R.id.card_sahara);
        cardEverest = view.findViewById(R.id.card_everest);

        cardSahara.setOnClickListener(v -> selectJourney("sahara"));
        cardEverest.setOnClickListener(v -> selectJourney("everest"));
    }

    private void selectJourney(String journey) {
        if (journey.equals("sahara")) {
            // Highlight Sahara
            cardSahara.setStrokeWidth(dpToPx(3));
            cardSahara.setStrokeColor(Color.parseColor("#3B82F6"));

            // Remove highlight from Everest
            cardEverest.setStrokeWidth(0);
        } else {
            // Highlight Everest
            cardEverest.setStrokeWidth(dpToPx(3));
            cardEverest.setStrokeColor(Color.parseColor("#3B82F6"));

            // Remove highlight from Sahara
            cardSahara.setStrokeWidth(0);
        }
    }

    // Helper to convert DP to Pixels for the stroke width
    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}