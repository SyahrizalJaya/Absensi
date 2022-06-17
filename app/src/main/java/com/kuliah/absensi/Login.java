package com.kuliah.absensi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kuliah.absensi.adapter.TemanAdapter;
import com.kuliah.absensi.database.DBController;
import com.kuliah.absensi.database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class Login extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    DBController controller = new DBController(this);
    String id,nm, tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        recyclerView = findViewById(R.id.recylerView);
        fab = findViewById(R.id.floatingBtn);

        BacaData();

        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Login.this);
        recyclerView.setLayoutManager (layoutManager);
        recyclerView.setAdapter (adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, TemanBaru.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData(){
        ArrayList<HashMap<String, String>> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();

        //memindah dari hasil query kedalam Teman
        for (int i = 0; i < daftarTeman.size(); i++) {
            Teman teman = new Teman();

            teman.setId(daftarTeman.get(i).get("id").toString());
            teman.setNama(daftarTeman.get(i).get("nama").toString());
            teman.setTelpon(daftarTeman.get(i).get("telpon").toString());
            //pindahkan dari Teman kedalam Arraylist teman di adapter
            temanArrayList.add(teman);
        }
    }
}