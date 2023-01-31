package com.baxicar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.lang.reflect.MalformedParameterizedTypeException;

public class MainBxActivity extends AppCompatActivity {

    //private CardView one_time_driver, one_time_passenger, constantly_driver, constantly_passenger, driver_need_help, ready_to_help;
    GridLayout mainGrid;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bx);

        CardView one_time_driver = findViewById(R.id.one_time_driver);
        one_time_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OneTimeDriverActivity.class);
                startActivity(intent);
            }
        });

        CardView one_time_passenger = findViewById(R.id.one_time_passenger);
        one_time_passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OneTimePassengerActivity.class);
                startActivity(intent);
            }
        });
        CardView constantly_driver = findViewById(R.id.constantly_driver);
        constantly_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConstantlyDriverActivity.class);
                startActivity(intent);
            }
        });
        CardView constantly_passenger = findViewById(R.id.constantly_passenger);
        constantly_passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConstantlyPassengerActivity.class);
                startActivity(intent);
            }
        });
        CardView driver_need_help = findViewById(R.id.driver_need_help);
        driver_need_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DriverNeedHelpActivity.class);
                startActivity(intent);
            }
        });
        CardView ready_to_help = findViewById(R.id.ready_to_help);
        ready_to_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadyToHelpActivity.class);
                startActivity(intent);
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            //name.setText(personName);
            //email.setText(personEmail);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.logout) {
            gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(Task<Void> task) {
                    finish();
                    startActivity(new Intent(MainBxActivity.this, SignInActivity.class));


                }
            });
            return true;
        }
        return true;
    }
}