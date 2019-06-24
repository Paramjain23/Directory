package com.example.directory;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fragment.HelloFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mNotLoginTv;
    private EditText musername;
    private  EditText mpassword;
    private Button mbutton;
    private TextView forgotpass;


    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musername =(EditText) findViewById(R.id.username);
        mpassword =(EditText) findViewById(R.id.password);
        mbutton =(Button) findViewById(R.id.login);
        forgotpass=(TextView) findViewById(R.id.forgotpassword);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ForgotPassActivity.class);
                i.putExtra(UtilsClass.Name_Login,"Forgot Password");
                startActivity(i);

            }


        });


        mNotLoginTv =(TextView) findViewById(R.id.textView4);
        mNotLoginTv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startRegisterScreen();
            }
        });
        mbutton.setOnClickListener(this);
    }
    private void startRegisterScreen(){
        Intent intent =new Intent( this,RegistrationActivity.class);
        intent.putExtra(UtilsClass.Name_Login, "sgsits coming..");
        startActivity(intent);

    }


//    public void button(View view) {
//        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
//    }


    private String Tag="Sgsits";
    public void onClick(View v) {
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.helloFragment, new HelloFragment(),"Hello");
//        fragmentTransaction.commit();
        switch (v.getId()){
            case R.id.login:
                Log.i(Tag,"Login Button clicked...");
                ValidateLoginScreen();
                break;
        }
    }

    private void ValidateLoginScreen() {
        if(musername.getText().toString().isEmpty()){
            Log.i(Tag,"Login Failed,Please Provide User Name...");
            Toast.makeText(this,"Login Failed,Please Provide user name...",Toast.LENGTH_LONG).show();
        }
        else if(mpassword.getText().toString().isEmpty()) {
            Log.i(Tag,"Login Failed,Please Provide Password...");
            Toast.makeText(this,"Login Failed,Please Provide Password...",Toast.LENGTH_LONG).show();

        }
        else if(musername.getText().toString().equals("Example@gmail.com")){
            if(mpassword.getText().toString().equals("12345")){
                Log.i(Tag,"Login Success...");
                Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
                StartHomeScreen();

            }else {
                Toast.makeText(this,"Please provide valid password...",Toast.LENGTH_LONG).show();
            }
        }

        else {
            Toast.makeText(this,"Please provide Valid User name...",Toast.LENGTH_LONG).show();
        }
    }

    private void StartHomeScreen() {
        Intent intent= new Intent(this,HomeActivity.class);
        intent.putExtra(UtilsClass.Name_Login,"Home Screen coming...");
        startActivity(intent);
    }
}
