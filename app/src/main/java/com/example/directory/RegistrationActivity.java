package com.example.directory;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mfirstname;
    private EditText mlastname;
    private EditText mcity;
    private EditText mpin;
    private EditText mEmail;
    private EditText mmobno;
    private Button mnext;

    private Calendar calendar= Calendar.getInstance();
    private int year, month, day;
    private EditText getDateEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getDateEt=findViewById(R.id.getDateEt);

        mfirstname =(EditText) findViewById(R.id.firstname);
        mlastname =(EditText) findViewById(R.id.lastname);
        mcity =(EditText) findViewById(R.id.city);
        mpin =(EditText) findViewById(R.id.pin);
        mEmail=(EditText) findViewById(R.id.email);
        mmobno=(EditText) findViewById(R.id.mobno);
        mnext=(Button) findViewById(R.id.next);
        mnext.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        try{
            String s = getIntent().getExtras().getString(UtilsClass.Name_Login);
            String ss =getIntent().getStringExtra(UtilsClass.Name_Login);
            Toast.makeText(RegistrationActivity.this,ss,Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(RegistrationActivity.this, "Error occur!", Toast.LENGTH_LONG).show();

        }
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        getDateEt.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    private String  Tag1 = "Sgsits";
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.next:
                Log.i(Tag1,"Next button clicked...");
                ValidateRegisterScreen();
                break;

        }
    }

    private void ValidateRegisterScreen() {
        if(mfirstname.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please provide First name...");
            Toast.makeText(this,"Registration Failed Please Provide First name..",Toast.LENGTH_LONG).show();

        }
        else if(mlastname.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please Provide Last name...");
            Toast.makeText(this,"Registration Failed Please provide Last name... ",Toast.LENGTH_LONG).show();
        }
        else if(mcity.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please provide City name...");
            Toast.makeText(this,"Registration Failed Please provide City name...",Toast.LENGTH_LONG).show();
        }
        else if(mpin.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please provide Pin...");
            Toast.makeText(this,"Registration Failed Please provide Pin...",Toast.LENGTH_LONG).show();
        }
        else if(mEmail.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please provide Email id...");
            Toast.makeText(this,"Registration Failed Please provide Email id...",Toast.LENGTH_LONG).show();
        }
        else if(mmobno.getText().toString().isEmpty()){
            Log.i(Tag1,"Registration Failed Please provide Mobile no.  ...");
            Toast.makeText(this,"Registration Failed Please provide Mobile no.  ...",Toast.LENGTH_LONG).show();
        }
        else{
            Log.i(Tag1,"Registration Succeessfully Done...");
            Toast.makeText(this,"Registration Successfully Done...",Toast.LENGTH_LONG).show();
        }
    }


}
