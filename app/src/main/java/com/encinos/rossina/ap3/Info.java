package com.encinos.rossina.ap3;

import android.app.Activity;
import android.os.Bundle;

public class Info extends Activity {
    //Método prinicipal de la Ventana predeterminada, llama el activity que será la pantalla principal, con el texto y logo de la ujat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
