package com.kuliah.absensi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk Button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    //Deklarasi variabel email dan password tersimpan
    String user1="admin", pass1="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btnLogin);

        //Menghubungkanvariabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edUsername);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);


        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                if(nama.equals(user1) & password.equals(pass1)){

                    //membuat objek untuk pindah halaman
                    Intent i = new Intent(MainActivity.this, Login.class);
                    //memasukan bundle kedalam intent
                    //berpindah ke halaman lain
                    startActivity(i);
                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_LONG);
                    t.show();

                    //menghapus isi dari edittext
                    edemail.getText().clear();
                    edpassword.getText().clear();
                }
                else if (!nama.equals(user1) & password.equals(pass1)){
                    Toast t = Toast.makeText(getApplicationContext(),"Email yang anda masukkan salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (nama.equals(user1) & !password.equals(pass1)){
                    Toast t = Toast.makeText(getApplicationContext(),"Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),"Email dan Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }
}
