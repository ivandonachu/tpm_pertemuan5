package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan5.database.AppDatabase;
import com.example.pertemuan5.database.Datadiri;

public class update extends AppCompatActivity {
    private String nama,name;
    private String addres,alamat;
    char kelamin,gender ;
    private int id;
    private AppDatabase appDatabase;
    private EditText etNama,etAlamat,etKelamin;
    private Button btnUpdate,btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        appDatabase = AppDatabase.intDB(getApplicationContext());


        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        alamat = intent.getStringExtra("alamat");
        kelamin = intent.getCharExtra("kelamin",' ');
        id = intent.getIntExtra("id",0);

        etNama = findViewById(R.id.et_namaUp);
        etAlamat = findViewById(R.id.et_alamatUp);
        etKelamin = findViewById(R.id.et_jeniskelUp);
        btnUpdate = findViewById(R.id.btn_updateUp);
        btnDelete = findViewById(R.id.btn_deleteUp);
        etNama.setText(nama);
        etAlamat.setText(alamat);
        etKelamin.setText(""+kelamin);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

    }

    void update(){
        name = etNama.getText().toString();
        addres = etAlamat.getText().toString();
        gender = etKelamin.getText().charAt(0);

        Datadiri item = new Datadiri();
        item.setNama(name);
        item.setAlamat(addres);
        item.setJkelamin(gender);
        item.setId(id);

        appDatabase.dao().updateData(item);
        finish();
    }

    void delete() {
    Datadiri item = new Datadiri();
    item.setId(id);
        appDatabase.dao().deleteData(item);
finish();

    }


}
