package com.example.tp1_a_rendre;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    Button send_button;
    EditText full_name, email, phone, address;
    Spinner city_spinner;
    RadioGroup gender;
    String selected_city;
    String selected_gender;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        city_spinner = findViewById(R.id.city_spinner);
        send_button = findViewById(R.id.send_btn);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);

        gender = findViewById(R.id.gender);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != -1){
                    RadioButton checked_gender = findViewById(checkedId);
                    selected_gender = checked_gender.getText().toString();
                }
            }
        });


        String[] cities = getResources().getStringArray(R.array.cities);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cities
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        city_spinner.setAdapter(adapter);

        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_city = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected_city = "";
            }
        });

        // Debugging if the gender is selected
        Log.d(TAG, "Gender : " + selected_gender);

        send_button.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    intent.putExtra("selected_city", selected_city);
                    intent.putExtra("full_name", full_name.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("address", address.getText().toString());
                    intent.putExtra("selected_gender", selected_gender);

                    startActivity(intent);
                }
        );
    }
}