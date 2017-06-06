package com.example.vanessa.shareyourstory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Escolar on 16/05/2017.
 */

public class diario1 extends AppCompatActivity {
    private EditText nuevahisto;
    private EditText contenido;
    BaseDeDatos bd = new BaseDeDatos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_diario1);
        super.onCreate(savedInstanceState);
        nuevahisto = (EditText)findViewById(R.id.nueva);
        contenido = (EditText)findViewById(R.id.contenido);
        Button iniciar= (Button)findViewById(R.id.boton_entrar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bd.addNota(nuevahisto.getText().toString(),contenido.getText().toString(),v);
                Intent iniciar = new Intent(getApplicationContext(), Lista.class);
                startActivity(iniciar);
            }
        });
    }

}
