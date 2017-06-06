package com.example.vanessa.shareyourstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button siguiente = (Button) findViewById(R.id.boton_femenino);
        Button sigue = (Button) findViewById(R.id.boton_masculino);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sigue = new Intent(getApplicationContext(),Femenino.class);
                startActivity(sigue);
            }
        });
        sigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sigues = new Intent(getApplicationContext(), Masculino.class);
                startActivity(sigues);
            }
        });
    }
}


