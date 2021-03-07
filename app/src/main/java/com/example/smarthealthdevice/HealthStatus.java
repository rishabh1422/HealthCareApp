package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smarthealthdevice.Medical.SugarLevelActivity;
import com.example.smarthealthdevice.Medical.database.Database;
import com.example.smarthealthdevice.Medical.database.SugarLevelModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HealthStatus extends AppCompatActivity {
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);
        initChart();
        getSugarRecords();
    }


    private void setGraphData(List<SugarLevelModel> sugarLevelModelList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        List<String> xAxisValues = new ArrayList<>();
        List<Entry> upperReading = new ArrayList<>();
        List<Entry> lowerReading = new ArrayList<>();

        for (int i = 0; i < sugarLevelModelList.size(); i++) {
            SugarLevelModel sugarLevelModel = sugarLevelModelList.get(i);
            Log.e("TAG", "" + sugarLevelModel.getDate().toString());
            xAxisValues.add(simpleDateFormat.format(sugarLevelModel.getDate()));
            upperReading.add(new Entry(i, sugarLevelModel.getUpperReading()));
            lowerReading.add(new Entry(i, sugarLevelModel.getLowerReading()));
        }

        dataSets = new ArrayList<>();
        LineDataSet set1, set2;

        set1 = new LineDataSet(upperReading, "Upper Reading");
        set1.setLineWidth(2f);

        set2 = new LineDataSet(lowerReading, "Lower Reading");
        set2.setColor(Color.BLUE);
        set1.setLineWidth(2f);

        dataSets.add(set1);
        dataSets.add(set2);

        chart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));

        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();
        chart.notifyDataSetChanged();
    }

    /**
     *
     */
    private void initChart() {
        chart = findViewById(R.id.sugar_level_chart);
        // background color
        chart.setBackgroundColor(Color.WHITE);
        chart.getDescription().setEnabled(false);

        // enable scaling and dragging
        chart.setDragEnabled(false);
        chart.setScaleEnabled(false);

        //to hide background lines
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

            xAxis.enableGridDashedLine(10f, 10f, 0f);
        }

        YAxis yAxis;
        {   // // Y-Axis Style // //
            yAxis = chart.getAxisLeft();

            // disable dual axis (only use LEFT axis)
            chart.getAxisRight().setEnabled(false);

            // axis range
            yAxis.setAxisMaximum(150f);
            yAxis.setAxisMinimum(50f);
        }
    }

    /**
     * get sugar records from database
     *
     * @return
     */
    public List<SugarLevelModel> getSugarRecords() {
        Database appDatabase = Database.getInstance(this);

        /* *
         *  Insert and get data using Database Async way
         */
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert single data for a date, if data already exist for that date than update it
                List<SugarLevelModel> sugarRecords = appDatabase.sugarLevelDao().getSugarLevelLastWeekRecords();

                setGraphData(sugarRecords);
            }
        });
        return null;
    }
}