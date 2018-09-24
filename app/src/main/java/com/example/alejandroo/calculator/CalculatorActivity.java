package com.example.alejandroo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private String num ="";//Aquí es on esta guardat el numero actual;
    private String numant ="";
    private char operacio = ' ';
    private int bandera = 0; //Una vegada donat a igual, els numeros de la pantalla desapareixen al introduir un nou dígit.
    private int bandera1 =0; //Mira si s'ha escrit el primer número avans d'apretar igual
    private int bandera3 =0;//Mira si s'ha posat una operació avans d'apretar igual
    private int bandera4 =0;//Mira si s'ha escrit un segon nombre abans d'apretar igual.
    private int bandera5 =0;//Bloqueja l'entrada a funcio igual si no s'han introduit un valor inicial + operador + segon valor.
    private TextView numview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview = findViewById(R.id.numview);
        numview.setText(num);
    }
    public void OnClickDigit(View view){
        Button b = (Button)view;
        //Toast.makeText(this, b.getText().toString(),Toast.LENGTH_SHORT).show();
        if(bandera==1){
            operacio = 0;
            num = (String) b.getText();
            numview.setText(num);
            bandera=0;
        }else if (bandera4==1) {
            num += b.getText().toString();
            numview.setText(num);
            bandera4=0;
            bandera5=1;
        }else{
            num += b.getText().toString();
            numview.setText(num);
        }bandera1=1;
    }
    public void onClickOperator(View view) {

        bandera3=1;
        Button b = (Button)view;
        numant = num;
        num = "";
        operacio = b.getText().toString().charAt(0);
        bandera4 = 1;
        //numview.setText(num);
        if(bandera==1){
            bandera=0;
        }

    }
    public void OnClickEquials(View view) {


        if(bandera1==1 && bandera3==1 && bandera5==1) {
            double x = Double.valueOf(num);
            double xant = Double.valueOf(numant);

            switch (operacio) {
                case '+':
                    num = Double.toString(x + xant);
                    break;
                case '-':
                    num = Double.toString(xant - x);
                    break;
                case 'x':
                    num = Double.toString(xant * x);
                    break;
                case ':':
                    if(x==0){
                        num="MathError";
                        numview.setText(num);
                    }else {
                        num = Double.toString(xant / x);
                    }
                    break;
                default:

                    break;
            }
            numview.setText(num);
            bandera = 1;
            bandera3=0;
            bandera5=0;
        }
    }
    public void OnClickC(View view) {

        operacio = 0;
        num = " ";
        numview.setText("0");
        bandera1=0;


    }
    }

