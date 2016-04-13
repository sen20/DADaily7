package com.androidbelieve.drawerwithswipetabs;

import android.app.AlarmManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reminder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText event;
    EditText date;
    EditText time;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        event=(EditText)findViewById(R.id.EventSelector);
        date=(EditText)findViewById(R.id.dateSelector);
        time=(EditText)findViewById(R.id.timeSelector);
        submit=(Button)findViewById(R.id.Submitbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Toast.makeText(getApplicationContext(), "Reminder Added", Toast.LENGTH_SHORT).show();
                    Reminder.this.finish();
                }

            }
        });
        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialogd = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialogd.show(ft, "Date Picker");
                }
            }
        });
        time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    TimeDialog dialogt = new TimeDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialogt.show(ft, "Time Picker");
                }
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("AM");
        categories.add("PM");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Select:"+item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(getApplicationContext(), "Please select either AM or PM", Toast.LENGTH_LONG).show();
    }

    public boolean validate(){
        boolean valid=false;
        String _date=date.getText().toString();
        String _time=time.getText().toString();
        Calendar c=Calendar.getInstance();
        if(event.getText().toString().isEmpty()){
            event.setError("This field is Compulsory");
            valid=false;
        }
        else if(_date.isEmpty()){
            date.setError("This field is Compulsory");
            valid=false;
        }
        else if(_time.isEmpty()){
            time.setError("This field is Compulsory");
            valid=false;
        }
        else{
            if(getDay(_date)!=null && getMonth(_date)!=null && getYear(_date)!=null){
                if(this.getMinute(_time)!=null && this.getHour(_time)!=null){
                    valid=true;
                }else{
                    valid=false;
                    date.setError("Not a Valid time");
                }
            }else {
                valid=false;
                date.setError("Not a valid date");
            }

        }
        return valid;
    }

    public String getDay(String date){
        String day;
        if(date.charAt(2)=='-') {
            day = date.substring(0, 2);
        }
        else if(date.charAt(1)=='-') {
            day = date.substring(0, 1);
        }
        else day=null;
        return day;
    }
    public String getMonth(String date){
        String month;
        if(date.charAt(5)=='-') {
            month=date.substring(3,5);
        //Toast.makeText(getApplicationContext(), month, Toast.LENGTH_LONG).show();
        }
        else if(date.charAt(4)=='-') {
            if(date.charAt(2)=='-')  {   month=date.substring(3,4); //Toast.makeText(getApplicationContext(), month, Toast.LENGTH_LONG).show();
             }
            else if(date.charAt(1)=='-'){month=date.substring(2,4); //Toast.makeText(getApplicationContext(), month, Toast.LENGTH_LONG).show();
             }
            else month=null;
        }
        else if(date.charAt(3)=='-'){ month=date.substring(2,3); //Toast.makeText(getApplicationContext(), month, Toast.LENGTH_LONG).show();
         }
        else month=null;
        return month;

    }
    public String getYear(String date){
        String year;
        if(date.charAt(date.length()-5)=='-') {
            year=date.substring(date.length()-4,date.length());
            //Toast.makeText(getApplicationContext(), year, Toast.LENGTH_LONG).show();
        }
        else year=null;
        return year;
    }
    public String getMinute(String time){
        String min;
        if(time.charAt(time.length()-2)==':'){
            min=time.substring(time.length()-1,time.length());
           // System.out.println(min);
        }
        else if(time.charAt(time.length()-3)==':'){
            min=time.substring(time.length()-2,time.length());
            //System.out.println(min);
        }
        else min=null;
        return min;
    }
    public String getHour(String time){
        String hr;
        if(time.charAt(1)==':'){
            hr=time.substring(0,1);
           // System.out.println(hr);
        }
        else if(time.charAt(2)==':'){
            hr=time.substring(0,2);
            //System.out.println(hr);
        }
        else hr=null;
        return hr;
    }
}
