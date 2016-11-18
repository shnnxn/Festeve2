package com.example.android.festeve;

import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

import com.firebase.client.Firebase;
/**import com.firebase.client.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
**/




import org.w3c.dom.Text;

import static android.R.attr.value;
import static com.firebase.client.Firebase.*;
//firebase imports


//------------------------------------------- CHANGE STARTS------------------------------------------------------//


public class create_fest extends AppCompatActivity {
    public EditText collegetext;
    public EditText nametext;
    public EditText citytext;
    public EditText date;
    public ImageButton imageButton;
    public Button button4;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fest);
//change

        Firebase.setAndroidContext(this);

        collegetext = (EditText) findViewById(R.id.collegetext);
        nametext = (EditText) findViewById(R.id.nametext);
        citytext = (EditText) findViewById(R.id.citytext);
        date = (EditText) findViewById(R.id.date);
        imageButton = (ImageButton) findViewById (R.id.imageButton);
        button4 = (Button) findViewById(R.id.button4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                final Firebase ref = new Firebase(Config.FIREBASE_URL);


                //Getting values to store
                String fest_name = nametext.getText().toString().trim();
                String college = collegetext.getText().toString().trim();
                String city = citytext.getText().toString().trim();
                String date_text = date.getText().toString().trim();

                //Creating Person object
                createFestclass fest = new createFestclass();

                //Adding values
                fest.setFestName(fest_name);
                fest.setCollege(college);
                fest.setCity(city);
                fest.setDate(date_text);

                //Storing values to firebase
                ref.child("create_fest").setValue(fest);


            }
        });
    }
}