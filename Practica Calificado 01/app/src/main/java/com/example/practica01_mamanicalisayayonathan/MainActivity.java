package com.example.practica01_mamanicalisayayonathan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    Button btnAnalizarFrases , btnLimpiar ;
    TextView txvCantidadVocalesCerradasF1,txvCantidadVocalesCerradasF2,txvFrasesIguales;
    EditText edtPrimeraFrase , edtSegundaFrase;
    int cantidadVocalCerradaF1 = 0 ,cantidadVocalCerradaF2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnalizarFrases = findViewById(R.id.btn_analizar_frases);
        btnLimpiar = findViewById(R.id.btn_limpiar);

        txvCantidadVocalesCerradasF1 = findViewById(R.id.txv_cantidad_vocales_cerradas_f1);
        txvCantidadVocalesCerradasF2 = findViewById(R.id.txv_cantidad_vocales_cerradas_f2);
        edtPrimeraFrase = findViewById(R.id.edt_primera_frase);
        edtSegundaFrase = findViewById(R.id.edt_segunda_frase);
        txvFrasesIguales = findViewById(R.id.txv_frases_iguales);
    }

    public void eventComparar(View view) {
        String f1 = edtPrimeraFrase.getText().toString() , f2 = edtSegundaFrase.getText().toString();
        if(!f1.equals("") && !f2.equals("")){
            if(f1.equals(f2)){
                txvFrasesIguales.setText("Si");
            }else{
                txvFrasesIguales.setText("No");
            }

            Pattern patronVocalCerrada = Pattern.compile("[IiíUu]");
            Matcher matcherVocalCerradaF1 = patronVocalCerrada.matcher(f1);
            Matcher matcherVocalCerradaF2 = patronVocalCerrada.matcher(f2);

            while (matcherVocalCerradaF1.find()){
                cantidadVocalCerradaF1++;
                Log.d("PC01" , matcherVocalCerradaF1.start()+"____"+ matcherVocalCerradaF1.group());
            }

            while (matcherVocalCerradaF2.find()){
                cantidadVocalCerradaF2++;
                Log.d("PC01" , matcherVocalCerradaF2.start()+"____"+matcherVocalCerradaF2.group());
            }

            txvCantidadVocalesCerradasF1.setText(""+cantidadVocalCerradaF1);
            txvCantidadVocalesCerradasF2.setText(""+cantidadVocalCerradaF2);
            cantidadVocalCerradaF1 = 0;
            cantidadVocalCerradaF2 = 0;

        }else{
            Toast.makeText(MainActivity.this, "Debe llenar las 2 casillas con una frase porfavor.", Toast.LENGTH_SHORT).show();
        }
    }

    public void EventLimpiar(View view) {
        btnAnalizarFrases.setEnabled(true);
        edtPrimeraFrase.setText("");
        edtSegundaFrase.setText("");

        txvCantidadVocalesCerradasF1.setText("0");
        txvCantidadVocalesCerradasF2.setText("0");
        txvFrasesIguales.setText("NO");

        cantidadVocalCerradaF1 = 0;
        cantidadVocalCerradaF2 = 0;
    }
}
