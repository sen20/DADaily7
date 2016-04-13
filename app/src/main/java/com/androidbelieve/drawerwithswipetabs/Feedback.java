package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    Button feedback;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        feedback=(Button)findViewById(R.id.feedback);
        text=(EditText)findViewById(R.id.backwas);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Your precious feedback has been recorded", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Feedback.this.finish();
                }else {
                    Snackbar.make(v, "Please write your feedback", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            }
        });

    }

}
