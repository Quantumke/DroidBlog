package ml.dev2dev.blogapp;

/**
 * Created by benson on 11/13/15.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Content extends AppCompatActivity {
    private Firebase reference;
    ConnectivityManager cm;
//    private ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
//        Initialize firebase
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        super.onStart();
        // Linked to the UI

        final TextView company_name= (TextView)findViewById(R.id.companyname);
        final TextView country = (TextView)findViewById(R.id.cont);
        final TextView email = (TextView)findViewById(R.id.mail);
        final TextView first_name = (TextView)findViewById(R.id.fname);
        final TextView last_name = (TextView)findViewById(R.id.lname);


        /*
        * Initialize the firebase App
        * The URL should point to the root node of your date that is stored in
        * the JSON format
        */
        reference = new Firebase("https://datadroid.firebaseio.com/");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*
                * This method enables you to change data on Firebase and it
                * Automatically updates it on the app.
                * Use typecasting to to "Set" to whatever data type you want
                * */
                String companyname = (String) dataSnapshot.getValue();
                company_name.setText(companyname);

//              Short Toast for notification
                Toast.makeText(getApplicationContext(), "Weather has changed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
//              IF it fails to update on Firebase
                Toast.makeText(getApplicationContext(), "Failed to update. Check connection!!", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        * Click listeners that change the values of the text view on click
        * */


    }
}