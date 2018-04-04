package com.example.trashbusters;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;

/**
 *
 */


public class registrationActivity extends AppCompatActivity {

    private users currentUser;
    private PopupWindow popupWindow;
    Button showPopupBtn, closePopupBtn;
    ConstraintLayout mainLayout;



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
        LayoutInflater layoutInflater = (LayoutInflater) registrationActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.popup2,null);

        mainLayout = (ConstraintLayout) findViewById(R.id.registrationLayout);
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
    
    
    
    /*
    public class registrationActivity extends AppCompatActivity {

userDatabaseDriver driver = new userDatabaseDriver(this);


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

    public void onSubmitClick(View view) {

        if(view.getId() == R.id.registrationSubmit) {
            EditText fname = (EditText) findViewById(R.id.editFirstName);
            EditText pass = (EditText) findViewById(R.id.editPassword);
            EditText lname = (EditText) findViewById(R.id.editLastName);
            EditText email = (EditText) findViewById(R.id.editEmail);
            EditText phoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
            EditText address = (EditText) findViewById(R.id.editAddress);
            EditText city = (EditText) findViewById(R.id.editCity);
            EditText state = (EditText) findViewById(R.id.editState);
            EditText zip = (EditText) findViewById(R.id.editZip);
          //  EditText dob = (EditText) findViewById(R.id.editDob);
            EditText dLicense = (EditText) findViewById(R.id.editLicense);
            EditText pnumber = (EditText) findViewById(R.id.editPlateNumber);

            String fnamestr = fname.getText().toString();
            String passstr = pass.getText().toString();
            String lnamestr = lname.getText().toString();
            String emailstr = email.getText().toString();
            String pnstr = phoneNumber.getText().toString();
            String adressstr = address.getText().toString();
            String citystr = city.getText().toString();
            String statestr = state.getText().toString();
            String zipstr = zip.getText().toString();
           // String dobstr = dob.getText().toString();
            String dLicensestr = dLicense.getText().toString();
            String pnumberstr = pnumber.getText().toString();



        }
        else

        {

           /*users c = new users();

           c.setFirstName(fnamestr);
           c.setLastName(lnamestr);
           c.setPassword(passstr);
           c.setEmail(emailstr);
           c.setPhoneNumber(pnstr);
           c.setAddress(adressstr);
           c.setCity(citystr);
           c.setState(statestr);
           c.setZip(zipstr);
           c.setDob(dobstr);
           c.setPlateNumber(pnumberstr);
           c.setLicenseNumber(dLicensestr);



        driver.insertUser();
*/
    /*
        }


    }
}

    
    
    
    
    */
  



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
