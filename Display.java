package com.example.david.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.david.helloworld.R.styleable.View;

public class Display extends AppCompatActivity {

    public final static String BOOK_KEY = "com.example.david.helloworld.book";
    public final static String CHAPTER_KEY = "com.example.david.helloworld.chapter";
    public final static String VERSE_KEY = "com.example.david.helloworld.verse";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void clickButton(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editBook = (EditText) findViewById(R.id.eBook);
        String mBook = editBook.getText().toString();

        EditText editChapter = (EditText) findViewById(R.id.eChapter);
        String mChapter = editChapter.getText().toString();

        EditText editVerse = (EditText) findViewById(R.id.eVerse);
        String mVerse = editVerse.getText().toString();

        //Add items into the intent
        intent.putExtra(BOOK_KEY, mBook);
        intent.putExtra(CHAPTER_KEY, mChapter);
        intent.putExtra(VERSE_KEY, mVerse);

        startActivity(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Display Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
