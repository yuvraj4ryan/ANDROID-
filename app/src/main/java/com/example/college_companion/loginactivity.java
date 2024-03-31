package com.example.college_companion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        // Find views
        EditText editTextSAPID = findViewById(R.id.editTextSAPID);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button loginButton = findViewById(R.id.buttonLogin);
        FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered SAP ID and password
7                String sapID = editTextSAPID.getText().toString();
                String password = editTextPassword.getText().toString();

                // Validate the SAP ID and password
                if (isValidCredentials(sapID, password)) {
                    Intent intent = new Intent(loginactivity.this,dashboardActivity.class);
                    startActivity(intent);
                } else {
                    // Display an error message if credentials are invalid
                    Toast.makeText(loginactivity.this, "Invalid SAP ID or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate SAP ID and password
    private boolean isValidCredentials(String sapID, String password) {
        // Validate SAP ID (11 digits number)
        if (sapID.length() != 11 || !isNumeric(sapID)) {
            return false;
        }
        // Validate password (minimum 8 characters with at least 1 special character)
        if (password.length() < 8 || !containsSpecialCharacter(password)) {
            return false;
        }
        return true;
    }

    // Method to check if a string is numeric
    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a string contains at least 1 special character
    private boolean containsSpecialCharacter(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
