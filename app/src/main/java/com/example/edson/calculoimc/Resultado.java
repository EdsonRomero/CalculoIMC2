package com.example.edson.calculoimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edson on 27/10/2015.
 */
public class Resultado extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent= getIntent();


        Bundle params = intent.getExtras();


        Float p = params.getFloat("peso");
        Float a = params.getFloat("altura");
        String sexo = params.getString("sexo");
        ImageView iv = (ImageView) findViewById(R.id.imageView2);

        Float imc ;

        imc = p/(a*a);

        String result= String.valueOf(imc);
        TextView resultado = (TextView) findViewById(R.id.txt_resultado);
        resultado.setText("IMC" +result + " Sexo " +sexo);

        if(imc< 18.5){

            iv.setImageResource(R.drawable.abaixopeso);
        }else if (imc >18.5 && imc < 24.9){
            iv.setImageResource(R.drawable.pesonormal);
        }else if (imc >=25 && imc <= 29.9){
            iv.setImageResource(R.drawable.sobrepeso);
        }else if(imc >=30 && imc <= 34.9){
            iv.setImageResource(R.drawable.grau1);
        }else if (imc >=35 && imc <= 39.9){
            iv.setImageResource(R.drawable.grau2);
        }else if (imc >= 40){
            iv.setImageResource(R.drawable.grau3);

        }







    }

    public void voltar(View view){


        finish();

    }

}


