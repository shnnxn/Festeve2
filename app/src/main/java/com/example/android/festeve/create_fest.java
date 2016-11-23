package com.example.android.festeve;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.Toast;
import com.firebase.client.Firebase;
import android.app.Dialog;






import org.w3c.dom.Text;

import static android.R.attr.enabled;
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
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        button4 = (Button) findViewById(R.id.button4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object

                /**  final Dialog dialog = new Dialog(create_fest.this);
                 dialog.setContentView(R.layout.dialog);**/

                //  button4=(Button)dialog.findViewById(R.id.button4);

                final Firebase ref = new Firebase(Config.FIREBASE_URL);


                //Getting values to store
                String fest_name = nametext.getText().toString().trim();
                String college = collegetext.getText().toString().trim();
                String city = citytext.getText().toString().trim();
                String s_date = date.getText().toString().trim();

                //Creating Person object
                createFestclass fest = new createFestclass();

                //Adding values
                fest.setFestName(fest_name);
                fest.setCollege(college);
                fest.setCity(city);
                fest.setDate(s_date);

                //Storing values to firebase
                ref.child("create_fest").setValue(fest);

                if(v.getId()==R.id.button4)
                {
                    Toast.makeText(getApplicationContext(), "Fest Created Successfully",Toast.LENGTH_SHORT).show();
                    Intent q=new Intent(getApplicationContext(),SelectFestActivity.class);
                    startActivity(q);

                }


                // code added


            }




        });
    }



}
