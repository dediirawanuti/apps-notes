package com.uti.catatan.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.uti.catatan.R;
import com.uti.catatan.helper.RealmHelper;

public class UpdateDataActivity extends AppCompatActivity {

    private EditText tvNama;
    private EditText tvKegiatan;
    private Button btnUpdate, btnHapus;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        Toolbar tbMW = findViewById(R.id.tbUpdate);
        setSupportActionBar(tbMW);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Data");

        final int id = getIntent().getIntExtra("DATA_ID", 0);
        String nama = getIntent().getStringExtra("DATA_NAMA");
        String kegiatan = getIntent().getStringExtra("DATA_KEGIATAN");

        initView();

        tvNama.setText(nama);
        tvKegiatan.setText(kegiatan);

        helper = new RealmHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tvNama.getText().toString();
                String kegiatan = tvKegiatan.getText().toString();
                helper.updateCatatan(id, nama, kegiatan);
                Toast.makeText(UpdateDataActivity.this, "Update Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.deleteCatatan(id);
                Toast.makeText(UpdateDataActivity.this, "Data Dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initView() {
        tvNama = findViewById(R.id.tv_nama);
        tvKegiatan = findViewById(R.id.tv_kegiatan);
        btnUpdate = findViewById(R.id.btn_update);
        btnHapus = findViewById(R.id.btn_hapus);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
