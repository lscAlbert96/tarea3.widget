package com.encinos.rossina.ap3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.RemoteViews;


public class WidgetEventos extends AppWidgetProvider {
    private Handler mHandler  = new Handler();
    RemoteViews views;
    AppWidgetManager appWidgetManager;
    ComponentName currentWidget;
    Context context;
    Calendar cal = Calendar.getInstance();

    //Método que usará el widget
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {

        this.context = context;
        this.appWidgetManager = appWidgetManager;
        /*pregunta que  elementos existen en el layout*/
        views = new RemoteViews(context.getPackageName(), R.layout.widget);
        currentWidget = new ComponentName(context, WidgetEventos.class);
        mHandler.removeCallbacks(actualizarReloj);
        mHandler.postDelayed(actualizarReloj, 100);
    }

    final Runnable actualizarReloj = new Runnable()
    {
        public void run()
        {
            Intent informationIntent = new Intent(context,TabHostPrincipal.class);
            PendingIntent infoPendingIntent = PendingIntent.getActivity(context, 0, informationIntent, 0);
            views.setOnClickPendingIntent(R.id.Widget, infoPendingIntent);
            views.setTextViewText(R.id.widget_textview,getDatos(cal.getTime()));
            appWidgetManager.updateAppWidget(currentWidget, views);
            mHandler.postDelayed(actualizarReloj, 1000);

        }
    };
    //captura y da formato a la fecha del sistema
    public String getDatos(Date date){
        SimpleDateFormat sdf = new
                SimpleDateFormat("h:mmaa");
        sdf.setLenient(false);
        String re = sdf.format(date.getTime());
        return re;
    }

    @Override
    public void onDisabled(Context context)
    {
        super.onDisabled(context);
        mHandler.removeCallbacks(actualizarReloj);
    }
}


