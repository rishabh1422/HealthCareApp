package com.example.smarthealthdevice.Medical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smarthealthdevice.Medical.database.Database;
import com.example.smarthealthdevice.Medical.database.SugarLevelModel;
import com.example.smarthealthdevice.R;
import com.example.smarthealthdevice.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SugarLevelActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText dateTextInput, upperReadingTextInput, lowerReadingTextInput;
    ImageView selectImageButton;
    Button saveButton;
    final int MINIMUM_SUGAR_LEVEL = 50;
    final int MAXIMUM_SUGAR_LEVEL = 120;
    Date selectedDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_leval);
        dateTextInput = findViewById(R.id.sugar_date_text_input);

        selectImageButton = findViewById(R.id.select_image_button);
        selectImageButton.setOnClickListener(this);

        lowerReadingTextInput = findViewById(R.id.sugar_lower_reading_textInput);
        upperReadingTextInput = findViewById(R.id.sugar_upper_reading_textInput);

        saveButton = findViewById(R.id.sugar_button_save);
        saveButton.setOnClickListener(this);

        dateTextInput.setText(Utils.formattedDate());
    }

    @Override
    public void onClick(View v) {
        // date picker click
        if (v == selectImageButton) {
            final Calendar c = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    selectedDate.setMonth(month);
                    selectedDate.setYear(year);
                    selectedDate.setDate(day);

                    dateTextInput.setText(Utils.formattedDate(day, month, year));
                }
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }

        // save button click event
        if (v == saveButton) {
            saveSugarRecord();
        }
    }

    // save sugar level data in room database
    public void saveSugarRecord() {
        float upperReading = 0;
        float lowerReading = 0;
        try {
            upperReading = Float.parseFloat(upperReadingTextInput.getText().toString());
            lowerReading = Float.parseFloat(lowerReadingTextInput.getText().toString());
        } catch (NumberFormatException e) {
        }
        // value validation
        if (Float.compare(upperReading, lowerReading) < 0) {
            //"upperReading < lowerReading"
            Toast.makeText(this, "Upper reading is less than lower reading", Toast.LENGTH_SHORT).show();
            return;
        }
        // reading must be between 50-120
        if ((Float.compare(upperReading, MINIMUM_SUGAR_LEVEL) < 0) ||
                (Float.compare(upperReading, MAXIMUM_SUGAR_LEVEL) > 0) ||
                (Float.compare(upperReading, MINIMUM_SUGAR_LEVEL) < 0) ||
                (Float.compare(upperReading, MAXIMUM_SUGAR_LEVEL) > 0)) {
            //"upperReading <lowerReading"
            Toast.makeText(this, "Reading must we between " + MINIMUM_SUGAR_LEVEL + " to " + MAXIMUM_SUGAR_LEVEL, Toast.LENGTH_SHORT).show();
            return;
        }

        Database appDatabase = Database.getInstance(this);
        SugarLevelModel sugarLevelModel = new SugarLevelModel(selectedDate, upperReading, lowerReading);

        /* *
         *  Insert and get data using Database Async way
         */
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert single data for a date, if data already exist for that date than update it
                List<SugarLevelModel> sugarRecords = appDatabase.sugarLevelDao().getSugarLevelRecord(selectedDate);
                if (sugarRecords.size() > 0) {
                    appDatabase.sugarLevelDao().updateSugarRecord(sugarLevelModel);
                    Log.e("TAG", "sugar level data Updated!!!");
                } else {
                    appDatabase.sugarLevelDao().insertSugarRecord(sugarLevelModel);
                    Log.e("TAG", "sugar level data saved!!!");
                }

                // show success msg
                SugarLevelActivity.this.runOnUiThread(new Runnable() {
                                                          public void run() {
                                                              Toast.makeText(SugarLevelActivity.this, "Data saved successfully.", Toast.LENGTH_SHORT).show();
                                                              // clear fields
                                                              upperReadingTextInput.setText("");
                                                              lowerReadingTextInput.setText("");
                                                              dateTextInput.setText(Utils.formattedDate());
                                                              upperReadingTextInput.requestFocus();
                                                          }
                                                      }
                );
            }
        });
    }
}