package com.example.a25hraf_z800.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegForm extends AppCompatActivity {

    EditText fullName, userName, eMail, regPassword, regPasswordCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);

        fullName = (EditText) findViewById(R.id.FullName);
        userName = (EditText) findViewById(R.id.RegUserName);
        eMail = (EditText) findViewById(R.id.RegEMail);
        regPassword = (EditText) findViewById(R.id.RegPassWord);
        regPasswordCon = (EditText) findViewById(R.id.RegPassWordCon);




        //regPasswordCon on text change listener
        regPasswordCon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 && regPassword.getText().toString().length() > 0) {
                    if (!(editable.toString().equals(regPassword.getText().toString()))) {
                        regPasswordCon.setTextColor(Color.parseColor("#ff0000"));
                    } else {
                        regPasswordCon.setTextColor(Color.parseColor("#000000"));
                    }
                }


            }
        });
        //regPasswordCon on text change listener end

        //regPassword on text change listener
        regPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 && regPassword.getText().toString().length() > 0) {
                    if (!(editable.toString().equals(regPasswordCon.getText().toString()))) {
                        regPasswordCon.setTextColor(Color.parseColor("#ff0000"));
                    } else {
                        regPasswordCon.setTextColor(Color.parseColor("#000000"));
                    }
                }


            }
        });
        //regPassword on text change listener end
    }

    public void register(View view) {
        Intent i = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("UserName", userName.getText().toString());
        b.putString("Password", regPassword.getText().toString());
        b.putString("EMail", eMail.getText().toString());
        b.putString("FullName", fullName.getText().toString());
        i.putExtras(b);
        startActivity(i);
    }
}
