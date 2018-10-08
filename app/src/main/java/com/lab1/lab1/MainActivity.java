package com.lab1.lab1;

import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        MenuItem secondItem = menu.findItem(R.id.second);
        secondItem.setEnabled(false);
        Button unlockMenuItemButton = findViewById(R.id.unlock2MenuItemButton);
        unlockMenuItemButton.setOnClickListener(event -> {
            if (!secondItem.isEnabled()) {
                secondItem.setEnabled(true);
                Toast.makeText(this, "Разблокирован 2 пункт меню", Toast.LENGTH_SHORT).show();
            }
        });

        MenuItem thirdItem = menu.findItem(R.id.third);
        unlockMenuItemButton = findViewById(R.id.unlock3MenuItemButton);
        unlockMenuItemButton.setOnClickListener(event -> {
            if (!thirdItem.isEnabled()) {
                thirdItem.setEnabled(true);
                Toast.makeText(this, "Разблокирован 3 пункт меню", Toast.LENGTH_SHORT).show();
            }
        });

        setOnItemMenuActions(menu);
        setDynamicsCreateToButton4(menu);
        return true;
    }

    private int last = 0;

    private void setDynamicsCreateToButton4(Menu menu) {

        findViewById(R.id.button4).setOnClickListener(event -> {
            String name = "NewButton" + last++;
            Toast.makeText(this, "Создана кнопка " + name, Toast.LENGTH_SHORT).show();
            MenuItem add = menu.add(name);
            add.setOnMenuItemClickListener(new DinamicButtonsListener(add, this));

        });
    }

    private void setOnItemMenuActions(Menu menu) {
        MenuItem item = menu.findItem(R.id.second);
        item.setOnMenuItemClickListener(event -> {
            Log.d("Выбран", "Выбран 2 пункт меню");
            return true;
        });

        item = menu.findItem(R.id.third);
        item.setOnMenuItemClickListener(event -> {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setMessage("Выбран 3 пункт меню")
                    .setTitle("Выбор")
                    .setPositiveButton("ОК", (dialogInterface, i) -> dialogInterface.cancel())
                    .create();
            dialog.show();
            return true;
        });

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

    public void firstOnClick(MenuItem item) {
        Toast.makeText(this, "Выбран 1 пункт меню", Toast.LENGTH_SHORT).show();
    }
}
