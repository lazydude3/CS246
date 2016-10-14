package com.example.david.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        String book = intent.getStringExtra(Display.BOOK_KEY);
        String chapter = intent.getStringExtra(Display.CHAPTER_KEY);
        String verse = intent.getStringExtra(Display.VERSE_KEY);

        TextView finalD = (TextView)findViewById(R.id.finalDisplay);
        finalD.setText("Your favorite Scrpture is: " + book + " " + chapter + ":" + verse);
    }
}
