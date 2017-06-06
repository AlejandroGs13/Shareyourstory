package com.example.vanessa.shareyourstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.vanessa.shareyourstory.R.id.nuevahistoria;

public class diario extends AppCompatActivity {
    private EditText nuevahisto;
    private EditText contenido;
    BaseDeDatos bd = new BaseDeDatos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_diario);
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

