package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pertemuan5.database.AppDatabase;

public class TampilData extends AppCompatActivity  {
    private AppDatabase appDatabase;
    private RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        appDatabase = AppDatabase.intDB(this);
        rc = findViewById(R.id.list_data);
rc.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        read();
    }

    private void read(){
        Adapter adapter = new Adapter(appDatabase.dao().getData(), this);
        rc.setAdapter(adapter);


    }

}

