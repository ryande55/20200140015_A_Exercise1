package com.example.Exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DaftarActivity  extends AppCompatActivity {
    //Menggunakan variabel dengan tipe data edittext
    EditText edtTaskmasuk, edtmjTask, edtmlTask;
    TextView tvNama;

    //Menggunakan variabel dengan tipe data floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        tvNama = findViewById(R.id.user);

        //Menggunakan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirim melalui method intet
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String nama = bundle.getString("a");

        //menampilkan value dari varibael email kedalam txEmail
        tvNama.setText(nama);

        edtTaskmasuk = (EditText) findViewById(R.id.tTaskmasuk);
        edtmjTask = (EditText) findViewById(R.id.mjTask);
        edtmlTask = (EditText) findViewById(R.id.mlTask);

        fab = (FloatingActionButton) findViewById(R.id.fabSimpan);

        //membuat method untuk event dari floating button

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String tTaskmasuk = edtTaskmasuk.getText().toString();
                String mjTask = edtmjTask.getText().toString();
                String mlTask = edtmlTask.getText().toString();

                //membuat kondisi untuk mengecek apakah Edittext kosong atau tidak
                if(tTaskmasuk.isEmpty()) {
                    Toast.makeText(DaftarActivity.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();

                }else if (mjTask.isEmpty()){
                    edtmjTask.setError("Jenis task");

                }else if (mlTask.isEmpty()) {
                    edtmlTask.setError("Lama task");

                }else if (tTaskmasuk.equals(tTaskmasuk) && (mjTask.equals(mjTask) && (mlTask.equals(mlTask))))
                {
                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    //dan dimasukkan kedalam bundle
                    b.putString("a", tTaskmasuk.trim());

                    //memasukkan value dari variabel nama dengan kunci "b"
                    //dan dimasukkan kedalam bundle
                    b.putString("b", mjTask.trim());

                    //memasukkan value dari variabel nama dengan kunci "c"
                    //dan dimasukkan kedalam bundle
                    b.putString("c", mlTask.trim());

                    //membuat objek intent berpindah activity dari DaftarActivity ke Hasil2Activity
                    Intent i = new Intent(getApplicationContext(), Hasil2Activity.class);

                    //memasukkan bundle intent untuk dikirimkan ke Hasil2Activity
                    i.putExtras(b);

                    //berpindah ke Hasil2Activity
                    startActivity(i);
                    Toast.makeText(DaftarActivity.this, "Suksess", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu,
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Memmbuat kondisi jika yang dipilih adalah id mendaftar
        if (item.getItemId() == R.id.mnSubmit)
        {
            String tTaskmasuk = edtTaskmasuk.getText().toString();
            String mjTask = edtmjTask.getText().toString();
            String mlTask = edtmlTask.getText().toString();

            //membuat objek bundle
            Bundle b = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("a", tTaskmasuk.trim());

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("b", mjTask.trim());

            b.putString("c", mlTask.trim());

            //membuat objek intent berpindah activity dari DaftarActivity ke Hasil2Activity
            Intent i = new Intent(getApplicationContext(), Hasil2Activity.class);

            //memasukkan bundle intent untuk dikirimkan ke Hasil2Activity
            i.putExtras(b);

            //berpindah ke ActivityHasil
            startActivity(i);
            Toast.makeText(DaftarActivity.this, "Suksess", Toast.LENGTH_SHORT).show();
        }

        else if (item.getItemId() == R.id.mnLogout)
        {
            //Method untuk memanggil activity "MainActivity"
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }

}