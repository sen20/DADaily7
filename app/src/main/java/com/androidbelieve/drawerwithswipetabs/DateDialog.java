package com.androidbelieve.drawerwithswipetabs;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

/**
 * Created by USER on 4/5/2016.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener  {
    EditText txtDate;

    public DateDialog(View view){
        txtDate=(EditText)view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year=c.get(Calendar.YEAR);
        return new DatePickerDialog(getActivity(),this,year,month,dayOfMonth);
    }
    public void onDateSet(DatePicker view, int year,int month,int day){
        String date=day+"-"+(month+1)+"-"+year;
        txtDate.setText(date);
    }
}
