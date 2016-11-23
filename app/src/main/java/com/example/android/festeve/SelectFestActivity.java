package com.example.android.festeve;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.*;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.firebase.client.FirebaseError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

import static com.example.android.festeve.R.id.nametext;



public class SelectFestActivity extends AppCompatActivity {
    private ListView selectfest;
    private String TAG="SelectFestActivity";
    private FirebaseListAdapter<createFestclass> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_fest);


        selectfest= (ListView) findViewById(R.id.selectfest);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.keepSynced(true);

        mAdapter = new FirebaseListAdapter<createFestclass>(this, createFestclass.class, android.R.layout.simple_list_item_1, myRef) {
            @Override
            protected void populateView(View view, createFestclass model , int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(createFestclass.getFestName());


            }
        };
        selectfest.setAdapter(mAdapter);


    }

    @Override
    public void onBackPressed() {
       /** DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);**/
        Intent q=new Intent(getApplicationContext(),FrontActivity.class);
        startActivity(q);
      /**  if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }**/
    }



}

