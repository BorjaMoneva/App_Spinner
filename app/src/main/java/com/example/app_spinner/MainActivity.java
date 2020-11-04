package com.example.app_spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Spinner s;
        ConstraintLayout clayout;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            clayout =  (ConstraintLayout)findViewById(R.id.cl1);
            s = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.colores_array, android.R.layout.simple_spinner_dropdown_item);
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s.setAdapter(adaptador);
            String color = s.getSelectedItem().toString();
            Toast.makeText(this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @RequiresApi(api = Build.VERSION_CODES.P)

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextView tv = (TextView) findViewById(R.id.tv_Pregunta);
                    if(s.getSelectedItem().toString().equals("negro")){
                        clayout.setBackgroundColor(getResources().getColor(R.color.negro));
                        tv.setTextColor(getResources().getColor(R.color.blanco));
                        s.setBackgroundResource(android.R.drawable.btn_dropdown);
                    }else{
                        tv.setTextColor(getResources().getColor(R.color.negro));
                        s.setBackgroundResource(android.R.drawable.btn_dropdown);
                    }
                    switch (s.getSelectedItem().toString()){
                        case "amarillo":
                            clayout.setBackgroundColor(getResources().getColor(R.color.amarillo));
                            break;
                        case "verde":
                            clayout.setBackgroundColor(getResources().getColor(R.color.verde));
                            break;
                        case "rojo":
                            clayout.setBackgroundColor(getResources().getColor(R.color.rojo));
                            break;
                        case "azul":
                            clayout.setBackgroundColor(getResources().getColor(R.color.azul));
                            break;
                        case "naranja":
                            clayout.setBackgroundColor(getResources().getColor(R.color.naranja));
                            break;
                        case "marron":
                            clayout.setBackgroundColor(getResources().getColor(R.color.marron));
                            break;
                        case "rosa":
                            clayout.setBackgroundColor(getResources().getColor(R.color.rosa));
                            break;
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }
