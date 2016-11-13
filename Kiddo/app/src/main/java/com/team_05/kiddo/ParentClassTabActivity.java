package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.Collections;

public class ParentClassTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_class_tab);

        TabHost tabHost = (TabHost) findViewById(R.id.pcTabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("announcements");
        spec1.setContent(R.id.pannouncementsTab);
        spec1.setIndicator("Announcements");
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("class_updates");
        spec2.setContent(R.id.classUpdatesTab);
        spec2.setIndicator("Class Updates");
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("pmessages");
        spec3.setContent(R.id.pMessagesTab);
        spec3.setIndicator("Messages");
        tabHost.addTab(spec3);

        // Settings button
        ImageButton settingsImageButton = (ImageButton)(findViewById(R.id.settingsImageButton));
        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentClassTabActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Back button
        ImageButton backImageButton = (ImageButton)(findViewById(R.id.backImageButton));
        backImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentClassTabActivity.this, ParentTabActivity.class);
                finish();
                startActivity(intent);
            }
        });

        // Create parent announcements ListView
        ListView pAnnouncementsListView = (ListView)findViewById(R.id.pAnnouncementsListView);
        ArrayList<String> announcements = new ArrayList<String>();
        announcements.add("Sat Nov 12 2:13 PM\nAnnouncement!");
        announcements.add("Sun Nov 13 10:59 AM\nAnnouncement again!");
        Collections.sort(announcements);

        ArrayAdapter<String> pAnnouncementsAdapter;
        pAnnouncementsAdapter = new ArrayAdapter<String>(ParentClassTabActivity.this, android.R.layout.simple_list_item_1, announcements);
        pAnnouncementsListView.setAdapter(pAnnouncementsAdapter);

        pAnnouncementsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ParentClassTabActivity.this, AnnouncementDetailsActivity.class);
                startActivity(intent);
            }
        });

        // Create parent updates ListView
        ListView pUpdatesListView = (ListView)findViewById(R.id.pUpdatesListView);
        ArrayList<String> updates = new ArrayList<String>();
        updates.add("Sat Nov 12 2:13 PM\nUpdate!");
        updates.add("Sun Nov 13 10:59 AM\nUpdate again!");
        Collections.sort(updates);

        ArrayAdapter<String> pUpdatesAdapter;
        pUpdatesAdapter = new ArrayAdapter<String>(ParentClassTabActivity.this, android.R.layout.simple_list_item_1, updates);
        pUpdatesListView.setAdapter(pUpdatesAdapter);

//        pUpdatesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(ParentClassTabActivity.this, AnnouncementDetailsActivity.class);
//                startActivity(intent);
//            }});
//
    }
}
