package com.example.android.festeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class enrollment extends AppCompatActivity {
    public EditText user_name;
    public EditText user_email;
    public EditText user_number;
    public EditText user_city;
    public EditText user_univ;
    public Button   enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        Firebase.setAndroidContext(this);

        user_name = (EditText) findViewById(R.id.user_name);
        user_email = (EditText) findViewById(R.id.user_email);
        user_number = (EditText) findViewById(R.id.user_number);
        user_city = (EditText) findViewById(R.id.user_city);
        user_univ = (EditText) findViewById(R.id.user_univ);
        enroll = (Button) findViewById(R.id.enroll);

        enroll.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View v)


            {
                final Firebase ref = new Firebase(Config.FIREBASE_URL);      //firebase url
                //Getting values to store
                String usr_name = user_name.getText().toString().trim();
                String usr_email = user_email.getText().toString().trim();
                String usr_number = user_number.getText().toString().trim();
                String usr_city = user_city.getText().toString().trim();
                String usr_univ = user_univ.getText().toString().trim();


                createEnrollclass Enroll = new createEnrollclass();   //getters and setters


                //Adding values
                Enroll.setusrname(usr_name);
                Enroll.setusremail(usr_email);
                Enroll.setusrnumber(usr_number);
                Enroll.setusrcity(usr_city);
                Enroll.setusruniv(usr_univ);

                ref.child("Enrollment").setValue(Enroll);    //storing into firebase


                if (v.getId() == R.id.enroll) {
                    Toast.makeText(getApplicationContext(), "Enrollment Succesfull", Toast.LENGTH_SHORT).show();
                    Intent q = new Intent(getApplicationContext(), SelectFestActivity.class);
                    startActivity(q);

                }


            }

            });





    }




}
