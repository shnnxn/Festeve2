package com.example.android.festeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.firebase.client.ChildEventListener;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.firebase.client.Firebase;
import java.util.Map;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;
import static com.example.android.festeve.R.id.nametext;



public class SelectFestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_fest);

    /**    Firebase.setAndroidContext(this);
        Firebase ref = new Firebase(Config.FIREBASE_URL);

        ref.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                createFestclass fest = dataSnapshot.getValue(createFestclass.class);
                System.out.println(fest.fest_name);
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                createFestclass fest = dataSnapshot.getValue(createFestclass.class);
                System.out.println(fest.fest_name);
            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {
                createFestclass fest = dataSnapshot.getValue(createFestclass.class);
                System.out.println(fest.fest_name);
            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                createFestclass fest = dataSnapshot.getValue(createFestclass.class);
                System.out.println(fest.fest_name);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });**/

    }


    }

