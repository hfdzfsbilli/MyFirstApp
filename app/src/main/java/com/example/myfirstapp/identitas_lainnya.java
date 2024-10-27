package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IdentitasLainnyaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas_lainnya);

        TextView textAlamat = findViewById(R.id.textAlamat);
        TextView textNoHp = findViewById(R.id.textNoHp);
        TextView textEmail = findViewById(R.id.textEmail);
        TextView textGender = findViewById(R.id.textGender);
        TextView textKelas = findViewById(R.id.textKelas);
        TextView textUkm = findViewById(R.id.textUkm);

        // Get data from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            textAlamat.setText("Alamat: " + extras.getString("alamat"));
            textNoHp.setText("No. HP: " + extras.getString("noHp"));
            textEmail.setText("Email: " + extras.getString("email"));
            textGender.setText("Jenis Kelamin: " + extras.getString("gender"));
            textKelas.setText("Kelas: " + extras.getString("kelas"));
            textUkm.setText("UKM: " + extras.getString("ukm"));
        }
    }
}
