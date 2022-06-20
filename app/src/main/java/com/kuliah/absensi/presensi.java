package com.kuliah.absensi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class presensi extends AppCompatActivity {

    String nma, tlp, id;
    TextView txNama,txNis;
    Button btnpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presensi);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        txNama = findViewById(R.id.txNama);
        btnpas = findViewById(R.id.btnpas);


        id = getIntent().getStringExtra("id");
        nma = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        txNama.setText(nma);

        btnpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertdb = new AlertDialog.Builder(view.getContext());
                alertdb.setTitle("Proses Presensi");
                alertdb.setMessage("Presensi " +nma+ " pada "+currentDate+" "+ currentTime +" Berhasil.....");
                alertdb.setCancelable(false);
                alertdb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(view.getContext(), "Presensi Berhasil", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(view.getContext(), Login.class);
                        view.getContext().startActivity(intent);
                    }
                });
                AlertDialog adlg= alertdb.create();
                adlg.show();
            }
        });
    }
}