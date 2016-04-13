package com.androidbelieve.drawerwithswipetabs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by USER on 4/2/2016.
 */
public class TimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText txtTime;
    public TimeDialog(View view){

        txtTime=(EditText)view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),this,hour,minute,false);
    }
    public void onTimeSet(TimePicker view, int hour,int minute){
        String time=hour+":"+minute;
        txtTime.setText(time);
    }
}
