package com.example.Exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity{
    //Menggunakan variabel dengan tipe data edittext
    EditText rgNama1, rgEmail1, rgPass1, rgRepass1;


    //Menggunakan variabel dengan tipe Button
    Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //String user = rgNama1.getText().toString();
        rgNama1 = (EditText) findViewById(R.id.user);
        rgEmail1 = (EditText) findViewById(R.id.idrgEmail);
        rgPass1 = (EditText) findViewById(R.id.idrgPass);
        rgRepass1 = (EditText) findViewById(R.id.idrgRepass);
        Btn = (Button) findViewById(R.id.idButton);

        //membuat method untuk event dari floating button
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat kondisi untuk mengecek apakah Edittext kosong atau tidak
                String nama = rgNama1.getText().toString();
                String email =  rgEmail1.getText().toString();
                String pass = rgPass1.getText().toString();
                String repass = rgRepass1.getText().toString();

                if(nama.isEmpty() && email.isEmpty())
                {
                    rgNama1.setError("");
                    rgEmail1.setError("");
                }

                else if (pass.equals(repass)){
                    Toast.makeText(RegisterActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    //membuat objek bundle
                    Bundle b = new Bundle();

                    b.putString("a", nama.trim());


                    //membuat objek intent berpindah activity dari Registeractivity ke DaftarHasil
                    Intent i = new Intent(getApplicationContext(), DaftarActivity.class);

                    //memasukkan bundle intent untuk dikirimkan ke DaftarHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);
                    
                }else if (pass != repass){
                    Toast.makeText(RegisterActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
                
            }

        });
    }
}
