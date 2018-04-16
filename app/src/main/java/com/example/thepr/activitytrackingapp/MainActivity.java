package com.example.thepr.activitytrackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefs";
    private static final String TAG = "someActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button btn1 =((Button)findViewById(R.id.savebutton));

        View.OnClickListener myListerner = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveProfileFromScreen();
                Toast.makeText(getApplicationContext(), "Profile saved.", Toast.LENGTH_SHORT).show();

                //Close activity
                finish();
            }
        };
        Button btn2 =((Button)findViewById(R.id.cancelbutton));

        View.OnClickListener myListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //clearscreen();
                Toast.makeText(getApplicationContext(), "Canceled.", Toast.LENGTH_SHORT).show();

                //Close activity
                finish();
            }
        };
    btn1.setOnClickListener(myListerner);
    btn2.setOnClickListener(myListener);

    loadProfileFromShared();
    }

    public void saveProfileFromScreen(){
        Log.d(TAG, "entered SaveProfileFromScreen");
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("Name",((EditText) findViewById(R.id.name)).getText().toString());
        editor.putString("Email",((EditText) findViewById(R.id.email)).getText().toString());
        editor.putString("Phone",((EditText) findViewById(R.id.phone)).getText().toString());
        editor.putString("Major",((EditText) findViewById(R.id.major)).getText().toString());

        editor.commit();
    }

    public void loadProfileFromShared(){
        Log.d(TAG, "entered loadProfileFromShared");
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String aName = prefs.getString("Name", "");
        if(aName.length()>0){
            ((EditText) findViewById(R.id.name)).setText(aName);
        }

        String aEmail = prefs.getString("Email", "");
        if(aName.length()>0){
            ((EditText) findViewById(R.id.email)).setText(aEmail);
        }

        String aPhone = prefs.getString("Phone", "");
        if(aName.length()>0){
            ((EditText) findViewById(R.id.phone)).setText(aPhone);
        }

        String aMajor = prefs.getString("Major", "");
        if(aName.length()>0){
            ((EditText) findViewById(R.id.major)).setText(aMajor);
        }
    }
}

