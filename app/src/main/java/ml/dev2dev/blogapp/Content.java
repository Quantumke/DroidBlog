package ml.dev2dev.blogapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by benson on 11/13/15.
 */
public class Content extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work);

        // Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.listView);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Use Firebase to populate the list.
        Firebase.setAndroidContext(this);

        new Firebase("https://YOUR-FIREBASE-APP.firebaseio.com/todoItems")
                .addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        adapter.add((String)dataSnapshot.child("company_name").getValue());
                        adapter.add((String)dataSnapshot.child("country").getValue());
                        adapter.add((String)dataSnapshot.child("email").getValue());
                        adapter.add((String)dataSnapshot.child("first_name").getValue());
                        adapter.add((String)dataSnapshot.child("last_name").getValue());
                    }
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        adapter.remove((String)dataSnapshot.child("company_name").getValue());
                        adapter.add((String) dataSnapshot.child("country").getValue());
                        adapter.add((String)dataSnapshot.child("email").getValue());
                        adapter.add((String)dataSnapshot.child("first_name").getValue());
                        adapter.add((String)dataSnapshot.child("last_name").getValue());

                    }
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                    public void onCancelled(FirebaseError firebaseError) { }
                });
    }


}
