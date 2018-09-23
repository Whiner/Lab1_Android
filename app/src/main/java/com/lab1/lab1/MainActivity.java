package com.lab1.lab1;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lab1.lab1.data.AuthorData;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        AuthorData authorData = new AuthorData("Саша", "Шиленко", 13, "ИС-16");
        setStudentInfo(authorData);
        setOnActionButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void setStudentInfo(AuthorData authorData) {
        TextView textView = findViewById(R.id.studentInfoTV);
        textView.setText(authorData.toString());
    }

    private void setOnActionButtons() {
        Button landscapeButton = findViewById(R.id.landscapeModeBT);
        landscapeButton.setOnClickListener(event -> {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });

        findViewById(R.id.showText).setOnClickListener(new ShowText(this));
    }


    public void changeLayout(View view) {
        setContentView(R.layout.second);
    }

    public void returnLayout(View view) {
        setContentView(R.layout.activity_main);
        init();
    }
}
