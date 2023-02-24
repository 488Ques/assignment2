package com.tri.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtNumber;
    Switch swGender;
    Spinner spLevel;
    SeekBar sbAge;
    CheckBox cbSport;
    RadioGroup radGrHobby;
    Button btnRegister;
    Button btnCancel;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        swGender = findViewById(R.id.swGender);
        spLevel = findViewById(R.id.spLevel);
        sbAge = findViewById(R.id.sbAge);
        cbSport = findViewById(R.id.cbSport);
        radGrHobby = findViewById(R.id.radGrHobby);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);
        tvResult = findViewById(R.id.tvResult);

        ArrayList<String> levels = new ArrayList<>();
        levels.add("CĐ");
        levels.add("ĐH");
        levels.add("CH");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, levels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLevel.setAdapter(dataAdapter);

        sbAge.setMax(90);

        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    swGender.setText("Nữ");
                } else {
                    swGender.setText("Nam");
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                Boolean gender = swGender.isChecked();
                String level = spLevel.getSelectedItem().toString();
                Integer age = sbAge.getProgress();
                Boolean doesSport = cbSport.isChecked();

                int selectedID = radGrHobby.getCheckedRadioButtonId();
                RadioButton radBtnHobby = findViewById(selectedID);
                String hobby = radBtnHobby.getText().toString();

                Person person = new Person(name, number, gender, level, age, doesSport, hobby);
                tvResult.setText(person.toString());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                edtNumber.setText("");
                swGender.setChecked(false);
                spLevel.setSelection(dataAdapter.getPosition("CĐ"));
                sbAge.setProgress(0);
                cbSport.setChecked(false);
                radGrHobby.clearCheck();
                tvResult.setText("");
            }
        });
    }
}