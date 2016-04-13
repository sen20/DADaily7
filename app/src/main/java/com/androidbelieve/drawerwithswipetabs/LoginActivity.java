package com.androidbelieve.drawerwithswipetabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app_.AppController;


public class LoginActivity extends AppCompatActivity {

    /**
     * A dummy authentication store containing known user names and passwords.

    // UI references.*/

    private EditText mPasswordView;
    private EditText mEmail;
    private View mProgressView;
    private View mLoginFormView;
    private Button Login;
    private Button SignUp;
    private TextView forgotPassword;
    private RequestQueue requestQueue;
   // private static final String URL="http:/192.168.56.1:80/dadaily/create_user.php";
    private StringRequest request;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.


        mPasswordView = (EditText) findViewById(R.id.input_password);
        mEmail = (EditText) findViewById(R.id.input_email);
        Login=(Button) findViewById(R.id.btn_login);
        SignUp=(Button)findViewById(R.id.btn_signup);
        forgotPassword=(TextView)findViewById(R.id.forgotPass);
        //requestQueue= Volley.newRequestQueue(this);
        forgotPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                if ( isEmailValid(email)&& !TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Automatically generated password has been sent " +
                            "to your webmail.Please login with that password",Toast.LENGTH_SHORT).show();
                } else mEmail.setError("Invalid Id");

            }
        });
        Login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        SignUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                LoginActivity.this.finish();
            }
        });

        //set all fields
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
// create sign up button and setup onclick listner

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {


        mPasswordView.setError(null);
        mEmail.setError(null);
        // Store values at the time of the login attempt.

        String password = mPasswordView.getText().toString();
        String email = mEmail.getText().toString();


        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.error_field_required));
            focusView = mEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmail.setError(getString(R.string.error_invalid_email));
            focusView = mEmail;
            cancel = true;
        }if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isEmailValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
    }


    private boolean isEmailValid(String email) {
        return email.length()==9;
    }


    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return (password.length()>=8 && password.length()<=12);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }










    /*public void makeJsonStringRequest(){

       String URL_LOGIN="http:://192.168.43.236:8012/DADaily/Login?webmail_id="+mEmail.getText().toString()+"?password="+mPasswordView.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Student")) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Please check internet connection",Toast.LENGTH_LONG);
            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest);

    }*/
}

