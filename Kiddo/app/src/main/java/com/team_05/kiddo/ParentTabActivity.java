package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.Collections;

public class ParentTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_tab);

        TabHost tabHost = (TabHost) findViewById(R.id.pTabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("classes");
        spec1.setContent(R.id.classesTab);
        spec1.setIndicator("Classes");
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("calendar");
        spec2.setContent(R.id.pCalendarTab);
        spec2.setIndicator("Calendar");
        tabHost.addTab(spec2);


        // Settings button
        ImageButton settingsImageButton = (ImageButton)(findViewById(R.id.settingsImageButton));
        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentTabActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Back button
        ImageButton backImageButton = (ImageButton)(findViewById(R.id.backImageButton));
        backImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentTabActivity.this, ChildrenActivity.class);
                finish();
                startActivity(intent);
            }
        });

        // Create classes ListView
        ListView pClassesListView = (ListView)findViewById(R.id.pClassesListView);
        ArrayList<String> classes = new ArrayList<String>();
        classes.add("Science");
        classes.add("English");
        Collections.sort(classes);

        ArrayAdapter<String> pClassesAdapter;
        pClassesAdapter = new ArrayAdapter<String>(ParentTabActivity.this, android.R.layout.simple_list_item_1, classes);
        pClassesListView.setAdapter(pClassesAdapter);

        pClassesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ParentTabActivity.this, ParentClassTabActivity.class);
                startActivity(intent);
            }
        });

        // Enrol in new courses button
        Button addClassButton = (Button)(findViewById(R.id.addClassButton));
        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentTabActivity.this, CourseEnrolmentActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }


}
