package com.encinos.rossina.ap3;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class TabHostPrincipal extends TabActivity {


//Evento que al dar clic en el ícono del widget despliegue una ventana con 3 pestañas (Info, " ", Alarma)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TabHost tab  = getTabHost();

        tab.addTab
                (tab.newTabSpec("Tab1").setIndicator
                        ("Info",getResources().getDrawable
                                (android.R.drawable.ic_dialog_info)).setContent
                        (new Intent(this,Info.class)));

        tab.addTab
                (tab.newTabSpec("Tab2").setIndicator
                        ("",getResources().getDrawable
                                (android.R.drawable.ic_menu_today)).setContent
                        (new Intent(this,Info.class)));

        tab.addTab
                (tab.newTabSpec("Tab3").setIndicator
                        ("Alarma",getResources().getDrawable
                                (android.R.drawable.ic_lock_idle_alarm)).setContent
                        (new Intent(this,Info.class).addFlags
                                (Intent.FLAG_ACTIVITY_CLEAR_TOP)));
    }
}
