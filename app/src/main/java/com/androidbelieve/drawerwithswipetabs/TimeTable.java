package com.androidbelieve.drawerwithswipetabs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Ratan on 7/29/2015.
 */
public class TimeTable extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getBaseContext());
        final CharSequence[] items = {
                "Medical electronics", "Stochastic", "Indian Cities and Literature"
        };

        builder.setTitle("Pick a Subject").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });
        return builder.create();

    }

    public void open6(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "Medical electronics", "Stochastic", "Indian Cities and Literature"
        };

        builder.setTitle("Subjects of Slot 6").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked" + dialog.toString() + "button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open7(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "Software Engineering", "Stochastic", "Indian Cities and Literature"
        };

        builder.setTitle("Subjects of Slot 7").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked"+dialog.toString()+"button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open5(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "Stat com", "Crypto", "Indian Cities and Literature"
        };

        builder.setTitle("Subjects of Slot 5").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked"+dialog.toString()+"button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open4(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "MOC", "SSD", "Ray"
        };

        builder.setTitle("Subjects of Slot 4").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked"+dialog.toString()+"button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open3(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "OS", "Stochastic", "Indian Cities and Literature"
        };

        builder.setTitle("Subjects of Slot 3").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked"+dialog.toString()+"button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open2(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "Nano", "Web data", "Indian Cities and Literature"
        };

        builder.setTitle("Subjects of Slot 2").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked"+dialog.toString()+"button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void open1(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = {
                "NPA", "IOT", "DSA"
        };

        builder.setTitle("Subjects of Slot 1").setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
                Toast.makeText(getApplicationContext(), "You clicked" + dialog.toString() + "button", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
