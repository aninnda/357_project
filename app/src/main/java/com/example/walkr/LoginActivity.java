package com.example.walkr;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MaterialButton btnGetStarted = findViewById(R.id.btn_get_started);
        MaterialButton btnFacebook = findViewById(R.id.btn_facebook);
        MaterialButton btnGoogle = findViewById(R.id.btn_google);

        // Safety check: Only set listeners if the buttons actually exist in the XML
        if (btnGetStarted != null) {
            btnGetStarted.setOnClickListener(view -> navigateToDashboard());
        }
        if (btnFacebook != null) {
            btnFacebook.setOnClickListener(view -> navigateToDashboard());
        }
        if (btnGoogle != null) {
            btnGoogle.setOnClickListener(view -> navigateToDashboard());
        }
    }

    // The method that actually moves the user to the main app
    private void navigateToDashboard() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

        // "finish()" destroys the login screen so the user doesn't
        // accidentally go back to it if they press the phone's back button
        finish();
    }
}