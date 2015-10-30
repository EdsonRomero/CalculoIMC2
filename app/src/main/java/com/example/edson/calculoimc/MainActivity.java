package com.example.edson.calculoimc;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private ImageView iv;
    EditText peso;
    EditText altura;
    private String[] sexo = new String[]{" ","Feminino","Masculinho"};
    private int[] sexoImgs={R.drawable.imc ,R.drawable.feminino,R.drawable.masculino};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,sexo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        peso = (EditText) findViewById(R.id.edt_peso);
        altura= (EditText) findViewById(R.id.edt_altura);

        iv = (ImageView) findViewById(R.id.imageView);

        sp = (Spinner) findViewById(R.id.spinner);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                iv.setImageResource(sexoImgs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void TelaResultado(View view){

        String sexoPosicao= (String) sp.getSelectedItem();
        long id = sp.getSelectedItemId();
        int posicao = sp.getSelectedItemPosition();

        Float p = Float.parseFloat(peso.getText().toString());
        Float a = Float.parseFloat(altura.getText().toString());



           Intent intent = new Intent(this, Resultado.class);


           Bundle params = new Bundle();
           params.putFloat("peso", p);
           params.putFloat("altura", a);
           params.putString("sexo", sexoPosicao);

           intent.putExtras(params);

           startActivity(intent);


       }


    @Override
    protected void onStart(){
        super.onStart();
        peso.setText(null);
        altura.setText(null);
        peso.setFocusableInTouchMode(true);
        peso.requestFocus();


    }


}

