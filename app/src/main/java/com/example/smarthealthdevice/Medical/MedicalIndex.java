package com.example.smarthealthdevice.Medical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.smarthealthdevice.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MedicalIndex extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText date;
    Button select;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_index);
        date=findViewById(R.id.emaial);
        select=findViewById(R.id.select);
    }

    @Override
    public void onClick(View v) {
        if(v==select)
        {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    date.setText(i+ ":" + (i1+1)+":"+i2);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }

    }
}