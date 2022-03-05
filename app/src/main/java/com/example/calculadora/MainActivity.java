package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Pantalla;
    private Button AC,Potencia,Borrar,Div,Mul,Suma,Resta,Uno,Dos,Tres,Cuatro,Cinco,Seis,Siete,Ocho,Nueve,Cero,Punto,Igual;
    private String input,respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pantalla=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Potencia=findViewById(R.id.potencia);
        Borrar=findViewById(R.id.borrar);
        Div=findViewById(R.id.div);
        Mul=findViewById(R.id.mul);
        Suma=findViewById(R.id.suma);
        Resta=findViewById(R.id.resta);
        Uno=findViewById(R.id.uno);
        Dos=findViewById(R.id.dos);
        Tres=findViewById(R.id.tres);
        Cuatro=findViewById(R.id.cuatro);
        Cinco=findViewById(R.id.cinco);
        Seis=findViewById(R.id.seis);
        Siete=findViewById(R.id.siete);
        Ocho=findViewById(R.id.ocho);
        Nueve=findViewById(R.id.nueve);
        Cero=findViewById(R.id.cero);
        Punto=findViewById(R.id.punto);
        Igual=findViewById(R.id.igual);


    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                input="";
                break;

            case"x":
                Resolver();
                input+="*";
                break;
            case"^":
                Resolver();
                input+="^";
                break;
            case"=":
                Resolver();
                respuesta=input;
                break;
            case"←":
                String newText=input.substring(0,input.length()-1);
                input= newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    Resolver();
                }
                input+=data;

        }
        Pantalla.setText(input);
    }
    private void Resolver(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try{
                double mul=Double.parseDouble(number[0])* Double.parseDouble(number[1]);
                input = mul+"";
            }
            catch (Exception e){


            }
        }
        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try{
                double div=Double.parseDouble(number[0])/ Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){


            }
        }
        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try{
                double pow=Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = pow+"";
            }
            catch (Exception e){


            }
        }
        else if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try{
                double sum=Double.parseDouble(number[0])+ Double.parseDouble(number[1]);
                input = sum+"";
            }
            catch (Exception e){


            }
        }
        else if (input.split("-").length>1){
            String number[]=input.split("-");
            //para restar de un numero negativo
            if (number[0]=="" && number.length==2){
                number[0]=0+"";

            }
            try{
               double res=0;
               if (number.length==2){
                   res= Double.parseDouble(number[0])-Double.parseDouble(number[1]);
               }
               else if (number.length==3){
                   res=Double.parseDouble(number[1])-Double.parseDouble(number[2]);
               }
                input = res+"";
            }
            catch (Exception e){

            }
        }
        //para eliminar el .0 de un numero entero
        String n[]=input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input=n[0];
            }
        }
        Pantalla.setText(input);

    }
}