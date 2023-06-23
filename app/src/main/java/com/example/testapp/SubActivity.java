package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Locale;

public class SubActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        textView = findViewById(R.id.textView);
        Button buttonBack = findViewById(R.id.button_buck);
        buttonBack.setOnClickListener(v -> finish());
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        String str = String.format(Locale.US, "%d/%d/%d",year, monthOfYear+1, dayOfMonth);
        textView.setText( str );

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePick();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
}
