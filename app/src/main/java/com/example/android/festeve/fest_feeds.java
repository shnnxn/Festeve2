package com.example.android.festeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class fest_feeds extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fest_feeds);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);


        ReadRss readrss=new ReadRss(this,recyclerView);
        readrss.execute();
    }
}
