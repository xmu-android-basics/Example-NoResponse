package io.github.xmu_android_basics.noresponse;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NoResponseActivity extends AppCompatActivity {
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultText = findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void longTimeOperation(View view) {
        Snackbar.make(view, "Button Clicked.\nBegin long time operation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        outputLongText();
    }

    private void outputLongText() {
        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < 1024; j++) {
                System.out.format("I: %d, J: %d%n", i, j);
                resultText.append("Long time operation: " + i + "\n");
            }

        }

    }
}
