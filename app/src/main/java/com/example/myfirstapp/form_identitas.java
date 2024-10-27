package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FormIdentitasActivity extends AppCompatActivity {

    private EditText inputAlamat, inputNoHp, inputEmail;
    private RadioButton radioLaki;
    private Spinner spinnerKelas;
    private CheckBox checkboxAmcc, checkboxHimssi, checkboxKoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_identitas);

        inputAlamat = findViewById(R.id.inputAlamat);
        inputNoHp = findViewById(R.id.inputNoHp);
        inputEmail = findViewById(R.id.inputEmail);
        radioLaki = findViewById(R.id.radioLaki);
        spinnerKelas = findViewById(R.id.spinnerKelas);
        checkboxAmcc = findViewById(R.id.checkboxAmcc);
        checkboxHimssi = findViewById(R.id.checkboxHimssi);
        checkboxKoma = findViewById(R.id.checkboxKoma);
        Button btnSimpan = findViewById(R.id.btnSimpan);

        // Set adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.kelas_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKelas.setAdapter(adapter);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormIdentitasActivity.this, IdentitasLainnyaActivity.class);
                intent.putExtra("alamat", inputAlamat.getText().toString());
                intent.putExtra("noHp", inputNoHp.getText().toString());
                intent.putExtra("email", inputEmail.getText().toString());
                intent.putExtra("gender", radioLaki.isChecked() ? "Laki-laki" : "Perempuan");
                intent.putExtra("kelas", spinnerKelas.getSelectedItem().toString());

                ArrayList<String> ukmList = new ArrayList<>();
                if (checkboxAmcc.isChecked()) ukmList.add("AMCC");
                if (checkboxHimssi.isChecked()) ukmList.add("HIMSSI");
                if (checkboxKoma.isChecked()) ukmList.add("KOMA");

                intent.putExtra("ukm", String.join(", ", ukmList));

                startActivity(intent);
            }
        });
    }
}
