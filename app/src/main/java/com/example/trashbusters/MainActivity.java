package com.example.trashbusters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * User id db will have 12 columns.
 * Invoice db will have 5 columns.
 */

public class MainActivity extends AppCompatActivity {

    private Button registerButton;
    private Button signinButton;

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
        Intent intent = new Intent(this, userMainMenuActivity.class);
        startActivity(intent);
    }

}
