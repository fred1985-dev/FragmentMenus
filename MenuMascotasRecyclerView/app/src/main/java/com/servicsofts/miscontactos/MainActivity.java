package com.servicsofts.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //declaro un arrary de la clase contacto
    ArrayList<Mascota> mascotas;
    //declaramos nuestro Recycler view
   private RecyclerView listaMacotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaMacotas = (RecyclerView) findViewById(R.id.rcViewContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMacotas.setLayoutManager(llm);
        this.inicializarContactos();
        this.inicializarAdaptador();

         //declaramos nuestro recyclerView que tenemos en nuestra activititi

    }

    public  void inicializarAdaptador(){
        ContactoAdaptador adapatador = new ContactoAdaptador(mascotas,this);
        listaMacotas.setAdapter(adapatador);
    }


    public void inicializarContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( R.mipmap.mascota1,"Catyy","5"));
        mascotas.add(new Mascota(R.mipmap.mascota2,"Ronny","3"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch(item.getItemId()){
            case R.id.miAcercaDe:
                Intent intentDos = new Intent(this,AcerdaDe.class);
                startActivity(intentDos);
                break;
            case R.id.miContacto:
                Intent intent = new Intent(this, formularioContacto.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}