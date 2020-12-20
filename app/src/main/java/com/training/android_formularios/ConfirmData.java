package com.training.android_formularios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmData extends AppCompatActivity {
    TextView name,phone,email,desc,date;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_data);

        String Name = getIntent().getExtras().getString("Name");
        String Phone = getIntent().getExtras().getString("Phone");
        String Email = getIntent().getExtras().getString("Email");
        String Desc = getIntent().getExtras().getString("Desc");
        String Date = getIntent().getExtras().getString("Date");

        name    = (TextView) findViewById(R.id.confName);
        date    = (TextView) findViewById(R.id.confDate);
        phone   = (TextView) findViewById(R.id.confPhone);
        email   = (TextView) findViewById(R.id.confEmail);
        desc    = (TextView) findViewById(R.id.confDesc);
        btnEdit = (Button) findViewById(R.id.editData);

        name.setText(Name);
        date.setText(getString(R.string.date)+Date);
        phone.setText(getString(R.string.phone)+Phone);
        email.setText(getString(R.string.email)+Email);
        desc.setText(getString(R.string.desc)+Desc);


        btnEdit.setOnClickListener(v -> {
                Intent intent = new Intent(ConfirmData.this, MainActivity.class);
                intent.putExtra("Name", Name);
                intent.putExtra("Phone", Phone);
                intent.putExtra("Email", Email);
                intent.putExtra("Desc", Desc);
                intent.putExtra("Date",Date);
                startActivity(intent);
                finish();

        });

    }
    public void onBackPressed(){
        Intent intent = new Intent(ConfirmData.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}