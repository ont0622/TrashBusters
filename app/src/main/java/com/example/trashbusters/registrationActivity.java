package com.example.trashbusters;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 *
 */


public class registrationActivity extends AppCompatActivity {

    private users currentUser;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        currentUser = new users();

        initTextChangedEvents();

    }
// for database entries
    private void initTextChangedEvents() {
        // for user name
        final EditText etUserName = (EditText) findViewById(R.id.editUserName);
        etUserName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                currentUser.setUserName(etUserName.getText().toString());
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count){

            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        int usertype;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioUser:
                if (checked)
                    // Fill out here when user is pressed. if user integer value = 1
                  //  u.getUserType());
                    usertype = 1;
                    break;
            case R.id.radioDriver:
                if (checked)
                    //Fill out here when driver is pressed. if driver integer value = 0
                usertype = 0;
                    break;
        }
    }


    public void onSubmitClick(View view) {
        //fill here for submit button. you will need to call database class for this. check textbook for more detail
        boolean wasSuccessful = false;
        userDataSource ds = new userDataSource(registrationActivity.this);
        try {
            ds.open();

            if (currentUser.getUserType()==1) {
                wasSuccessful = ds.insertUser(currentUser);
            }
            else {
                wasSuccessful = ds.updateUser(currentUser);
            }
            ds.close();
        }
        catch (Exception e) {
            wasSuccessful = false;
        }

    }



/* textbook example:

    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.registrationSubmit);
        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean wasSuccessful = false;
                userDataSource ds = new userDataSource(registrationActivity.this);
                try {
                    ds.open();

                    if (currentUser.getUserType()==1) {
                        wasSuccessful = ds.insertUser(currentUser);
                    }
                    else {
                        wasSuccessful = ds.updateUser(currentUser);
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                }

            }
        });
    }
*/
}
