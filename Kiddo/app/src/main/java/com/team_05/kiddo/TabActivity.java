package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TabActivity extends AppCompatActivity {

    String newAnnouncement;

    public static ArrayList<String> announcements = new ArrayList<String>();

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
        final ListView announcementsListView = (ListView)findViewById(R.id.announcementsListView);

        final ArrayAdapter<String> announcementsAdapter;
        announcementsAdapter = new ArrayAdapter<String>(TabActivity.this, android.R.layout.simple_list_item_1, announcements);
        announcementsListView.setAdapter(announcementsAdapter);

        // Send button
        ImageButton sendImageButton = (ImageButton)findViewById(R.id.sendImageButton);
        sendImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Set date and time
                Calendar calendar = Calendar.getInstance();
                TimeZone timeZone = calendar.getTimeZone();
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d h:mm a");
                sdf.setTimeZone(timeZone);
                Date date = new Date();
                String dateAndTime = sdf.format(date);

                // Append new announcement to date and time
                // Send announcement
                String dateAndTimeAnnouncement = dateAndTime + "\n" + newAnnouncement;
                announcements.add(dateAndTimeAnnouncement);
                announcementsAdapter.notifyDataSetChanged();

                // Clear announcements text field after sending
                EditText announcementsEditText = (EditText)findViewById(R.id.announcementsTextField);
                announcementsEditText.setText("");
            }
        });

        // Announcements text field
        EditText announcementsEditText = (EditText)findViewById(R.id.announcementsTextField);
        announcementsEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                newAnnouncement = v.getText().toString();

                return handled;
            }
        });


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


        // Create calendar ListView
        ListView calendarListView = (ListView)findViewById(R.id.calendarListView);
        ArrayList<String> events = new ArrayList<String>();
        events.add("Nov 12\nPicnic");
        events.add("Nov 12\nPicnic");
        events.add("Nov 12\nPicnic");

        ArrayAdapter<String> calendarAdapter;
        calendarAdapter = new ArrayAdapter<String>(TabActivity.this, android.R.layout.simple_expandable_list_item_1, events);
        calendarListView.setAdapter(calendarAdapter);
    }


}
