package com.example.a25hraf_z800.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox rememberMe;
    EditText loginUsername, loginPassword, loginPasswordCon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUsername = (EditText) findViewById(R.id.LoginUsername);
        loginPassword = (EditText) findViewById(R.id.LoginPassword);
        loginPasswordCon = (EditText) findViewById(R.id.LoginPasswordCon);
        rememberMe = (CheckBox) findViewById(R.id.RememberMe);

        //start of checkbox listener
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    loginPasswordCon.setVisibility(View.VISIBLE);
                } else {
                    loginPasswordCon.setVisibility(View.GONE);
                }
            }
        });
        //End of checkbox listener

        //loginPasswordCon on text change listener
        loginPasswordCon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 && loginPassword.getText().toString().length() > 0) {
                    if (!(editable.toString().equals(loginPassword.getText().toString()))) {
                        loginPasswordCon.setTextColor(Color.parseColor("#ff0000"));
                    } else {
                        loginPasswordCon.setTextColor(Color.parseColor("#000000"));
                    }
                }


            }
        });
        //loginPasswordCon on text change listener end

        //loginPassword on text change listener
        loginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 && loginPassword.getText().toString().length() > 0) {
                    if (!(editable.toString().equals(loginPasswordCon.getText().toString()))) {
                        loginPasswordCon.setTextColor(Color.parseColor("#ff0000"));
                    } else {
                        loginPasswordCon.setTextColor(Color.parseColor("#000000"));
                    }
                }


            }
        });
        //loginPassword on text change listener end

    }

    //login onClick button
    public void Login(View view) {
        if (rememberMe.isChecked()) {
            if (loginUsername.getText().toString().trim().equalsIgnoreCase("admin") && loginPassword.getText().toString().equals(loginPasswordCon.getText().toString()) && loginPassword.getText().toString().equals("admin")) {
                Intent i = new Intent(this, MainAppPage.class);
                startActivity(i);
                finish();
            } else if (loginPassword.getText().toString().trim().equals("") || loginUsername.getText().toString().trim().equals("") || loginPasswordCon.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Username or Password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a Valed Username and Password", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (loginUsername.getText().toString().trim().equalsIgnoreCase("admin") && loginPassword.getText().toString().equals("admin")) {
                Intent i = new Intent(this, MainAppPage.class);
                startActivity(i);
                finish();
            } else if (loginPassword.getText().toString().trim().equals("") || loginUsername.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Username or Password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a Valed Username and Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //login button onClick end

    //register button onClick

    public void register(View view) {
        Intent i = new Intent(this, RegForm.class);
        startActivity(i);
        finish();
    }
    //register button onClick end
}
