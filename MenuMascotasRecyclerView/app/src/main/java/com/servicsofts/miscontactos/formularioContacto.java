package com.servicsofts.miscontactos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import   java.util.Properties;
public class formularioContacto extends AppCompatActivity  implements View.OnClickListener {

    Button btnEnviar;
    EditText editTextEmail, editTextNombre, editTextMensaje;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        //creamos una referencia a la variable que hemos creado
        btnEnviar=findViewById(R.id.btEnviar);
        editTextEmail = findViewById(R.id.cEmail);
        editTextNombre = findViewById(R.id.cNombre);
        editTextMensaje = findViewById(R.id.cMensaje);

        //asignacion evento click
        btnEnviar.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {
        //para checkbox
        String email = editTextEmail.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String mensaje = editTextMensaje.getText().toString();
        Properties props = new Properties();
      // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
// TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
// Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");
// Nombre del usuario
        props.setProperty("mail.smtp.user", email);
// Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");
    }
}