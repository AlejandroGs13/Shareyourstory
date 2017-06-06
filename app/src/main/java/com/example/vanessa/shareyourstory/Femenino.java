package com.example.vanessa.shareyourstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Femenino extends AppCompatActivity {
    private CheckBox recordarpwd;
    private CheckBox muestrapwd;
    private EditText passwd;
    private EditText ID;
    BaseDeDatos bd = new BaseDeDatos(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_femenino);
        recordarpwd = (CheckBox)findViewById(R.id.checkbox1);
        muestrapwd = (CheckBox)findViewById(R.id.checkbox2);
        passwd = (EditText)findViewById(R.id.password);
        ID = (EditText)findViewById(R.id.usuario);

        Button iniciar= (Button)findViewById(R.id.boton_entrar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(v);
                //bd.addUsuario(ID.getText().toString(),passwd.getText().toString());
                Intent iniciar = new Intent(getApplicationContext(), diario.class);
                startActivity(iniciar);
            }
        });
    }
    public void mostrarPWD(View v){
        int cursor = passwd.getSelectionEnd();
        if(muestrapwd.isChecked()){
            passwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else{
            passwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        passwd.setSelection(cursor);
    }
    public void iniciar(View v) {
        if (recordarpwd.isChecked()) {
            Toast.makeText(this, "recordare tu usuario", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No recordare tu usuario", Toast.LENGTH_SHORT).show();
        }
    }}

