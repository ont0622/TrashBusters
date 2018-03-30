package com.example.trashbusters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

/**
 *
 */

public class registrationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioUser:
                if (checked)
                    // Fill out here when user is pressed
                    break;
            case R.id.radioDriver:
                if (checked)
                    //Fill out here when driver is pressed
                    break;
        }
    }
}
