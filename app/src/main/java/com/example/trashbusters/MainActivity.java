package com.example.trashbusters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

/*
 * User id db will have 12 columns.
 * Invoice db will have 5 columns.
 */

public class MainActivity extends AppCompatActivity {

    private Button registerButton;
    private Button signinButton;
    private PopupWindow popupWindow;
    Button showPopupBtn, closePopupBtn;
    ConstraintLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = (Button) findViewById(R.id.registerbutton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegister();
            }

        });

        signinButton = (Button) findViewById(R.id.signinbutton);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }

        });
    }


    public void toRegister() {
        Intent intent = new Intent(this, registrationActivity.class);
        startActivity(intent);
    }

    public void signIn() {
        EditText type = (EditText) findViewById(R.id.editUser);
        String userInput = type.getText().toString();
        if (userInput.equals("Peter")){
            Intent intent = new Intent(this, userMainMenuActivity.class);
            startActivity(intent);
        }
        else if (userInput.equals("Cameron")){
            Intent intent = new Intent(this, driverMainMenuActivity.class);
            startActivity(intent);
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = layoutInflater.inflate(R.layout.popup,null);

            mainLayout = (ConstraintLayout) findViewById(R.id.mainLayout);
            closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);

            //instantiate popup window
            popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            //display the popup window
            popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

            //close the popup window on button click
            closePopupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
        }
    }

}


/*

public class MainActivity extends AppCompatActivity {

userDatabaseDriver driver = new userDatabaseDriver(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginClick(View view) {
        if (view.getId() == R.id.signinbutton) {
            EditText lusername = (EditText) findViewById(R.id.editUser);
            EditText lpassword = (EditText) findViewById(R.id.editPass);




*/
