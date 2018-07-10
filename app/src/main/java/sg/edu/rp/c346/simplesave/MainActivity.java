package sg.edu.rp.c346.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //step1 :Obtain an instance of the SharedPrefences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //step2: Obtain an instance of the sharedpreference Editor for the update later
        SharedPreferences.Editor prefEdit =prefs.edit();
        //step3:Add the key-value pair
        prefEdit.putString("greeting","Hello!");
        //step4:call commit(0 method to save the changes into the Sharedpreferences
        prefEdit.commit();

        //new line
    }

    @Override
    protected void onResume() {
        super.onResume();
        //String msg ="No greeting!";

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("greeting","No greetings");
        Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();
    }

}
