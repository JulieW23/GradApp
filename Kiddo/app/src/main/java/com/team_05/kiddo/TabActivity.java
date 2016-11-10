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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("announcements");
        spec1.setIndicator("", getResources().getDrawable(R.drawable.ic_announcement_black_24dp_rgb));
        spec1.setContent(R.id.announcements);
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("students");
        spec2.setIndicator("", getResources().getDrawable(R.drawable.ic_people_black_24dp_rgb));
        spec2.setContent(R.id.students);
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("groupMessage");
        spec3.setIndicator("", getResources().getDrawable(R.drawable.ic_message_black_24dp_rgb));
        spec3.setContent(R.id.groupMessage);
        tabHost.addTab(spec3);

        TabHost.TabSpec spec4 = tabHost.newTabSpec("calendar");
        spec4.setIndicator("", getResources().getDrawable(R.drawable.ic_event_black_24dp_rgb));
        spec4.setContent(R.id.calendar);
        tabHost.addTab(spec4);

        TabHost.TabSpec spec5 = tabHost.newTabSpec("enrolmentRequests");
        spec5.setIndicator("", getResources().getDrawable(R.drawable.ic_note_add_black_24dp_rgb));
        spec5.setContent(R.id.enrolmentRequests);
        tabHost.addTab(spec5);

        // Settings button®
        ImageButton settingsImageButton = (ImageButton)(findViewById(R.id.settingsImageButton));
        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Back button
        ImageButton backImageButton = (ImageButton)findViewById(R.id.backImageButton);
        backImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Create announcements ListView
        ListView announcementsListView = (ListView)findViewById(R.id.announcementsListView);
        ArrayList<String> announcements = new ArrayList<String>();
        announcements.add("Nov 12\nDon't forget we have a picnic today!");
        announcements.add("Nov 13\nThere is no school tomorrow.");
        announcements.add("Nov 14\nI am sick today.");
        announcements.add("Nov 15\nDon't forget we have a picnic today!");
        announcements.add("Nov 16\nThere is no school tomorrow.");
        announcements.add("Nov 17\nI am sick today.");
        announcements.add("Nov 18\nDon't forget we have a picnic today!");
        announcements.add("Nov 19\nThere is no school tomorrow.");
        announcements.add("Nov 20\nI am sick today.");
        announcements.add("Today\nThis is the latest announcement.");


        ArrayAdapter<String> announcementsAdapter;
        announcementsAdapter = new ArrayAdapter<String>(TabActivity.this, android.R.layout.simple_list_item_1, announcements);
        announcementsListView.setAdapter(announcementsAdapter);

        // Create students ListView
        ListView studentsListView = (ListView)findViewById(R.id.studentsListView);
        ArrayList<String> students = new ArrayList<String>();
        students.add("Jimmy");
        students.add("Mike");
        students.add("John");
        students.add("Jimmy");
        students.add("Mike");
        students.add("John");
        students.add("Jimmy");
        students.add("Mike");
        students.add("John");
        students.add("Jimmy");
        students.add("Mike");
        students.add("John");
        Collections.sort(students);

        ArrayAdapter<String> studentsAdapter;
        studentsAdapter = new ArrayAdapter<String>(TabActivity.this, android.R.layout.simple_list_item_1, students);
        studentsListView.setAdapter(studentsAdapter);

        studentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TabActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });

        // Create group message ListView
        ListView groupMessageListView = (ListView)findViewById(R.id.groupMessageListView);
        ArrayList<String> groupMessages = new ArrayList<String>();
        groupMessages.add("Jimmy");
        groupMessages.add("Mike");
        groupMessages.add("John");
        groupMessages.add("Jimmy");
        groupMessages.add("Mike");
        groupMessages.add("John");
        groupMessages.add("Jimmy");
        groupMessages.add("Mike");
        groupMessages.add("John");
        groupMessages.add("Jimmy");
        groupMessages.add("Mike");
        groupMessages.add("John");
        Collections.sort(groupMessages);

        ArrayAdapter<String> groupMessageAdapter;
        groupMessageAdapter = new ArrayAdapter<String>(TabActivity.this, android.R.layout.select_dialog_multichoice, groupMessages);
        groupMessageListView.setAdapter(groupMessageAdapter);
    }
}
