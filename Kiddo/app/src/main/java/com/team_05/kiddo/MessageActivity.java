package com.team_05.kiddo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // Back button
        ImageButton backImageButton = (ImageButton)(findViewById(R.id.backImageButton));
        backImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Create messages ListView
        ListView messagesListView = (ListView)findViewById(R.id.messagesListView);
        ArrayList<String> messages = new ArrayList<String>();
        messages.add("9:00PM Jimmy\nIn computer science, a data structure is a particular way of organizing data in a computer so that it can be used efficiently.[1][2] Data structures can implement one or more particular abstract data types (ADT), which specify the operations that can be performed on a data structure and the computational complexity of those operations. In comparison, a data structure is a concrete implementation of the specification provided by an ADT.");
        messages.add("9:05PM Me\nDifferent kinds of data structures are suited to different kinds of applications, and some are highly specialized to specific tasks. For example, relational databases commonly use B-tree indexes for data retrieval,[3] while compiler implementations usually use hash tables to look up identifiers.");
        messages.add("9:10PM Jimmy\nData structures provide a means to manage large amounts of data efficiently for uses such as large databases and internet indexing services. Usually, efficient data structures are key to designing efficient algorithms. Some formal design methods and programming languages emphasize data structures, rather than algorithms, as the key organizing factor in software design. Data structures can be used to organize the storage and retrieval of information stored in both main memory and secondary memory.");

        ArrayAdapter<String> messagesAdapter;
        messagesAdapter = new ArrayAdapter<String>(MessageActivity.this, android.R.layout.simple_list_item_1, messages);
        messagesListView.setAdapter(messagesAdapter);
    }
}
