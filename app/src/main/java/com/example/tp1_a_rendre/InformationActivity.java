package com.example.tp1_a_rendre;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {

    TextView info_full_name,
            info_email,
            info_address,
            info_phone,
            info_city,
            info_gender;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        info_full_name = findViewById(R.id.info_full_name);
        info_email = findViewById(R.id.info_email);
        info_address = findViewById(R.id.info_address);
        info_phone = findViewById(R.id.info_phone);
        info_city = findViewById(R.id.info_city);
        info_gender = findViewById(R.id.info_gender);


        info_full_name.setText("Nom : " + getIntent().getStringExtra("full_name"));
        info_email.setText("Email : " + getIntent().getStringExtra("email"));
        info_address.setText("Adresse : " + getIntent().getStringExtra("address"));
        info_phone.setText("Phone : " + getIntent().getStringExtra("phone"));
        info_city.setText("Ville : " + getIntent().getStringExtra("selected_city"));
        info_gender.setText("Genre : " + getIntent().getStringExtra("selected_gender"));
    }
}
