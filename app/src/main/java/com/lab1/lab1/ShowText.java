package com.lab1.lab1;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowText implements View.OnClickListener {
    private MainActivity activity;

    public ShowText(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        TextView userTextTV = activity.findViewById(R.id.userTextTV);
        EditText editTextPT = activity.findViewById(R.id.editText);
        if (!editTextPT.getText().toString().replace(" ", "").equals("")) {
            userTextTV.setText(editTextPT.getText());
        } else {
            Toast.makeText(activity, "Введите текст в поле", Toast.LENGTH_LONG).show();
        }
    }
}
