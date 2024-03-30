package com.example.college_companion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class dashboardActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);

            // Initialize the GridView
            GridView gridView = findViewById(R.id.imageButtonsGridView);

            // List of image resource IDs for the ImageButtons
            List<Integer> imageButtonIds = new ArrayList<>();
            imageButtonIds.add(R.drawable.assignments);
            imageButtonIds.add(R.drawable.attendance);
            imageButtonIds.add(R.drawable.results);
            imageButtonIds.add(R.drawable.timetable);





            // Set up adapter for the GridView
            ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, imageButtonIds) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    ImageButton imageButton;
                    if (convertView == null) {
                        imageButton = new ImageButton(getContext());
                        // Set fixed dimensions for the ImageButton
                        imageButton.setLayoutParams(new GridView.LayoutParams(300, 300));
                        imageButton.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        imageButton.setPadding(8, 8, 8, 8);
                    } else {
                        imageButton = (ImageButton) convertView;
                    }

                    // Set image resource for the ImageButton
                    imageButton.setImageResource(getItem(position));
                    // Set content description for accessibility
                    imageButton.setContentDescription(getResources().getResourceEntryName(getItem(position)));

                    return imageButton;
                }
            };

            gridView.setAdapter(adapter);

            // Set click listener for grid items if needed
            gridView.setOnItemClickListener((parent, view, position, id) -> {
                // Handle item click here
                Toast.makeText(dashboardActivity.this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
            });
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==R.id.action_logout){
                Toast.makeText(this, "logout Selected", Toast.LENGTH_SHORT).show();
                return true;

            } else if (item.getItemId() == R.id.action_profile) {
                Intent intent = new Intent(dashboardActivity.this, profile.class);
                startActivity(intent);
                return true;
            }


            return false;
        }

    }
