package com.a13x.temp_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;



public class MainActivity extends AppCompatActivity {
    private Spinner Menu1, Menu2;
    private EditText Edt_temp1, Edt_temp2;
    float C,F,K,res;
    String valores1, valores2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Enlasando textView al xmL*/
        Edt_temp1=(EditText) findViewById(R.id.editText_temp1);
        Edt_temp2=(EditText) findViewById(R.id.editText_temp2);

         /*arreglo tipo string*/
        final String[] datos =
                new String[] {"Grados", "Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

         /*Enlasando menu al xmL*/
        Menu1 = (Spinner)findViewById(R.id.spinner_menu1);
        Menu2 = (Spinner)findViewById(R.id.spinner_menu2);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Menu1.setAdapter(adaptador);
        Menu2.setAdapter(adaptador);

        /*obteniendo el grado seleccionado  */
        Menu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {

                valores1 = datos[position];

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Menu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {

                valores2 = datos[position];
                //evalua las variables valores
                if(valores2 == "Grados" && valores1 == "Grados"){
                }
                else{
                    //Verificar qeu la textview este vacia
                    String vacio = Edt_temp1.getText().toString();
                }
                if(valores1 == "Celsius" && valores2 == "Fahrenheit"){
                    C = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de C° a F°
                    res = (C * 1.8f) + 32;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }
                if(valores1 == "Fahrenheit" && valores2 == "Celsius"){
                    F = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de F° a C°
                    res = (F - 32)/1.8f;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }
                if(valores1 == "Celsius" && valores2 == "Kelvin"){
                    C = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de C° a K°
                    res = C+273.15f;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }
                if(valores1 == "Kelvin" && valores2 == "Celsius"){
                    K = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de K° a C°
                    res = K-273.15f;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }
                if(valores1 == "Kelvin" && valores2 == "Fahrenheit"){
                    K = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de k° a f°
                    res = ((K-273.15f)*1.8f)+32;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }

                if(valores1 == "Fahrenheit" && valores2 == "Kelvin"){
                    F = Float.parseFloat(Edt_temp1.getText().toString());
                    //Formula de F° a K°
                    res = (5*(F-32)/9)+273.15f;
                    //Pasando el resultado en un dato tipo string
                    String resultado = String.valueOf(res);
                    //Despues ya se muestra en la segunda text view
                    Edt_temp2.setText(resultado);
                }

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
