package com.lab1.lab1;

import android.view.MenuItem;
import android.widget.Toast;

public class DinamicButtonsListener implements MenuItem.OnMenuItemClickListener {
    private final MainActivity mainActivity;
    private MenuItem menuItem;

    public DinamicButtonsListener(MenuItem menuItem, MainActivity mainActivity) {
        this.menuItem = menuItem;
        this.mainActivity = mainActivity;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(
                mainActivity,
                "Нажат пункт меню '" + menuItem.getTitle() + "'",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}
