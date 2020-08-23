package com.servicsofts.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //declaro un arrary de la clase contacto
    ArrayList<Mascota> mascotas;
    //declaramos nuestro Recycler view
    private RecyclerView listaMacotas;

    //fragment
    private Toolbar toolbar;
    private TableLayout tableLayout;
    private ViewPager viewPager;



    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
        }


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
}