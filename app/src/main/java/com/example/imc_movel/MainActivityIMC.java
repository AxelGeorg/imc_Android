package com.example.imc_movel;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityIMC extends AppCompatActivity {


    EditText Peso, Altura;
    TextView ResultadoIMC, ResultadoOBS ;
    RadioButton Feminino, Masculino;
    ImageView ResultadoImagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Quando digitar a altura digite com . ao invés de ,", Toast.LENGTH_SHORT).show();
    }

    public void CalcularIMC(View v){

        Peso = findViewById(R.id.pesoText);
        Altura = findViewById(R.id.AlturaText);
        ResultadoIMC = findViewById(R.id.ResultadoView);
        ResultadoImagem = findViewById(R.id.imageViewIMC);

        String PesoP = Peso.getText().toString();
        String AlturaA = Altura.getText().toString();

        float finalPeso = Float.parseFloat(PesoP);
        float finalAltura = Float.parseFloat(AlturaA);

        float IMC = (finalPeso/(finalAltura*finalAltura));

        String ResultIMC = String.valueOf(IMC);

        ResultadoIMC.setText(ResultIMC);


            if(IMC>=39){
                Toast toast = Toast.makeText(getApplicationContext(), "Obesidade Morbida", Toast.LENGTH_LONG);
                toast.show();
                Drawable drawable= getResources().getDrawable(R.drawable.gordao);
                ResultadoImagem.setImageDrawable(drawable);
            }else if((IMC>=29)||(IMC<=38.9)){
                Toast.makeText(getApplicationContext(), "Obesidade Moderada", Toast.LENGTH_LONG).show();
                Drawable drawable= getResources().getDrawable(R.drawable.gordo);
                ResultadoImagem.setImageDrawable(drawable);
            }else if((IMC>=24)||(IMC<=28.9)){
                Toast.makeText(getApplicationContext(), "Obesidade Leve", Toast.LENGTH_LONG).show();
                Drawable drawable= getResources().getDrawable(R.drawable.gordinho);
                ResultadoImagem.setImageDrawable(drawable);
            }else if((IMC>=19)||(IMC<=23.9)){
                Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_LONG).show();
                Drawable drawable= getResources().getDrawable(R.drawable.magro);
                ResultadoImagem.setImageDrawable(drawable);
            }else if(IMC<19){
                Toast.makeText(getApplicationContext(), "Abaixo do Normal", Toast.LENGTH_LONG).show();
                Drawable drawable= getResources().getDrawable(R.drawable.magrinho);
                ResultadoImagem.setImageDrawable(drawable);
            }

    }

}
