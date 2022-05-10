package com.ggstudio.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preços
        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textRes             = findViewById(R.id.textRes);

    }

    public void calcularPreco(View view) {

        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados == true){
            Double valorA = Double.parseDouble(precoAlcool);
            Double valorG = Double.parseDouble(precoGasolina);

            Double res = valorA / valorG;
            if (res >= 0.7){
                textRes.setText("Melhor utilizar Gasolina");
            }else {
                textRes.setText("Melhor utilizar Alcool");
            }

        }else{
            textRes.setText("Campos não preenchidos corretamente");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }else if ( pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;
    }

}