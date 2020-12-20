package com.training.android_formularios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmData extends AppCompatActivity {
    private TextView name,phone,email,desc;
    private Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_data);

        String Name = getIntent().getExtras().getString("Name");
        String Phone = getIntent().getExtras().getString("Phone");
        String Email = getIntent().getExtras().getString("Email");
        String Desc = getIntent().getExtras().getString("Desc");

        name    = (TextView) findViewById(R.id.confName);
        phone   = (TextView) findViewById(R.id.confPhone);
        email   = (TextView) findViewById(R.id.confEmail);
        desc    = (TextView) findViewById(R.id.confDesc);
        btnEdit = (Button) findViewById(R.id.editData);

        name.setText(Name);
        phone.setText(Phone);

        btnEdit.setOnClickListener(v -> {
                String Names = name.getText().toString();
                String Phones = phone.getText().toString();
                String Emails = email.getText().toString();
                String Descs = desc.getText().toString();
                Intent intent = new Intent(ConfirmData.this, MainActivity.class);
                intent.putExtra("Name", Names);
                intent.putExtra("Phone", Phones);
                intent.putExtra("Email", Emails);
                intent.putExtra("Desc", Descs);

        });
    }



}