package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class CourseEnrolmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_enrolment);

        // Back button
        ImageButton backImageButton = (ImageButton)(findViewById(R.id.backImageButton));
        backImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseEnrolmentActivity.this, AddChildActivity.class);
                finish();
                startActivity(intent);
            }
        });

        // Create classes ListView
        ListView classEnrolListView = (ListView)findViewById(R.id.classEnrolListView);
        ArrayList<String> classes = new ArrayList<String>();
        classes.add("Science");
        classes.add("English");
        Collections.sort(classes);

        ArrayAdapter<String> classEnrolAdapter;
        classEnrolAdapter = new ArrayAdapter<String>(CourseEnrolmentActivity.this, android.R.layout.simple_list_item_1, classes);
        classEnrolListView.setAdapter(classEnrolAdapter);
    }
}
