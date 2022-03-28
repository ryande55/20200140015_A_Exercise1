package com.example.Exercise1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hasil2Activity extends AppCompatActivity {
    //Menggunakan variabel dengan tipe data TextView
    TextView txTask, txJenis, txTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txTask = findViewById(R.id.tTaskmasuk1);

        txJenis = findViewById(R.id.mjTask1);

        txTime = findViewById(R.id.mlTask1);

        //Menggunakan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirimkan melalui metod intent
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String tTaskmasuk1 = bundle.getString("a");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String mjTask1 = bundle.getString("b");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String mlTask1 = bundle.getString("c");

        //menampilkan value dari variabel email ke dalam txEmail
        txTask.setText(tTaskmasuk1);

        //menampilkan value dari variabel email ke dalam txPassword
        txJenis.setText(mjTask1);
        txTime.setText(mlTask1);


    }
}
