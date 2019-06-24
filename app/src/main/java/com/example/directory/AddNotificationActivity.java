package com.example.directory;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddNotificationActivity extends AppCompatActivity {
    private Calendar calendar=Calendar.getInstance();
    private int year,month,date;
    private EditText startd;
    private EditText Endd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notification);
        startd=(EditText) findViewById(R.id.startDate);
        Endd=(EditText) findViewById(R.id.endDate);
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        date=calendar.get(Calendar.DAY_OF_MONTH);
        try{
            String s = getIntent().getExtras().getString(UtilsClass.Name_Login);
            String ss =getIntent().getStringExtra(UtilsClass.Name_Login);
            Toast.makeText(AddNotificationActivity.this,ss,Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(AddNotificationActivity.this, "Error occur!", Toast.LENGTH_LONG).show();

        }

    }
    public void setDate(View view){
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==999){
            return new DatePickerDialog(this,myDateListener,year,month,date);
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
        startd.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    public void setDate2(View view){
        showDialog(999);
    }


    protected Dialog onCreateDialog2(int id) {
        if(id==999){
            return new DatePickerDialog(this,myDateListener2,year,month,date);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener2 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate2(arg1, arg2+1, arg3);
                }
            };

    private void showDate2(int year, int month, int day) {
        Endd.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


}
