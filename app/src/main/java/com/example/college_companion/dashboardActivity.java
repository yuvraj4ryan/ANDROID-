package com.example.college_companion;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

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

                // Set click listener for the ImageButton
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle click event for each ImageButton
                        switch (position) {
                            case 0:
                                // Handle click for first ImageButton
                                Intent intent0 = new Intent(dashboardActivity.this, AssignmentActivity.class);
                                startActivity(intent0);
                                break;
                            case 1:
                                // Handle click for second ImageButton
                                Intent intent1 = new Intent(dashboardActivity.this, AttendanceActivity.class);
                                startActivity(intent1);
                                break;
                            case 2:
                                // Handle click for third ImageButton
                                Intent intent2 = new Intent(dashboardActivity.this, ResultsActivity.class);
                                startActivity(intent2);
                                break;
                            case 3:
                                // Handle click for fourth ImageButton
                                Intent intent3 = new Intent(dashboardActivity.this, TimetableActivity.class);
                                startActivity(intent3);
                                break;
                        }
                    }
                });

                return imageButton;
            }
        };

        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            Intent intent = new Intent(dashboardActivity.this, loginactivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.action_profile) {
            Intent intent = new Intent(dashboardActivity.this, profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}