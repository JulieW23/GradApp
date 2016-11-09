package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("announcements");
        spec1.setIndicator("A");
        spec1.setContent(R.id.announcements);
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("students");
        spec2.setIndicator("S");
        spec2.setContent(R.id.students);
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("groupMessage");
        spec3.setIndicator("GM");
        spec3.setContent(R.id.groupMessage);
        tabHost.addTab(spec3);

        TabHost.TabSpec spec4 = tabHost.newTabSpec("calendar");
        spec4.setIndicator("C");
        spec4.setContent(R.id.calendar);
        tabHost.addTab(spec4);

        TabHost.TabSpec spec5 = tabHost.newTabSpec("enrolmentRequests");
        spec5.setIndicator("ER");
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
    }
}
