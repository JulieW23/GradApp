package com.team_05.kiddo;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Login button
        Button loginButton = (Button)(findViewById(R.id.loginButton));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If login is admin

                // If login is teacher

                // If login is parent

                // Temp login
                // Switch to whatever activity you want to test it on
                Intent intent = new Intent(MainActivity.this, TeacherInitialLoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        // Sign up button
        Button signupButton = (Button)(findViewById(R.id.signupButton));
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ParentInfo.class);
                finish();
                startActivity(intent);
            }
        });
    }


}
