package com.example.android.festeve;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import android.content.Intent;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FrontActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //firebase
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull final FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.i("AuthStateChanged", "User is signed in with uid: " + user.getUid());
                } else {
                    Log.i("AuthStateChanged", "No user is signed in.");
                }
            }
        });






        //fab search

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent a=new Intent(getApplicationContext(),searchresult.class);
                startActivity(a);
                /**Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent a=new Intent(getApplicationContext(),searchresult.class);
                                startActivity(a);
                                //whatever you want to do when "Action" is clicked in the SnackBar
                            }
                        }).show();**/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.front, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ffeeds) {
            Intent a=new Intent(getApplicationContext(),fest_feeds.class);
            startActivity(a);


        } else if (id == R.id.cal) {
            Intent b=new Intent(getApplicationContext(),FestCalendarActivity.class);
            startActivity(b);

        } else if (id == R.id.register) {
            Intent c=new Intent(getApplicationContext(),enrollment.class);
            startActivity(c);

        } else if (id == R.id.interested) {
            Intent d=new Intent(getApplicationContext(),intrested.class);
            startActivity(d);

        } else if (id == R.id.signup) {
            Intent e=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(e);

        } else if (id == R.id.createfest) {
            Intent f=new Intent(getApplicationContext(),create_fest.class);
            startActivity(f);

        } else if (id == R.id.modifyfest) {
            Intent g=new Intent(getApplicationContext(),SelectFestActivity.class);
            startActivity(g);
            //if empty = display no entries
            //else display open the page with all the entries in database with a feature to change

        } else if (id == R.id.delfest) {
            Intent h=new Intent(getApplicationContext(),SelectFestActivity.class);
            startActivity(h); //to access same options as in modify

        } else if (id == R.id.venroll) {
            Intent i=new Intent(getApplicationContext(),ViewEnrollmentActivity.class);
            startActivity(i);

        }

///changes end/




       /** //checking for authentication
        Firebase ref = new Firebase(Config.FIREBASE_URL);
        ref.addAuthStateListener(new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    Toast.makeText(FrontActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FrontActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                }
            }
        }); **/

        //changes end


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
