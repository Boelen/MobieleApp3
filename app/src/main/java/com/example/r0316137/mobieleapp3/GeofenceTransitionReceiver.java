package com.example.r0316137.mobieleapp3;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

/**
 * Created by Tom on 28/11/2015.
 */
public class GeofenceTransitionReceiver extends WakefulBroadcastReceiver {

    public static final String TAG = GeofenceTransitionReceiver.class.getSimpleName();

    private Context context;

    public GeofenceTransitionReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive(context, intent)");
        this.context = context;
        GeofencingEvent event = GeofencingEvent.fromIntent(intent);
        if(event != null){
            if(event.hasError()){
                onError(event.getErrorCode());
            } else {
                int transition = event.getGeofenceTransition();
                if(transition == Geofence.GEOFENCE_TRANSITION_ENTER || transition == Geofence.GEOFENCE_TRANSITION_DWELL || transition == Geofence.GEOFENCE_TRANSITION_EXIT){
                    String[] geofenceIds = new String[event.getTriggeringGeofences().size()];
                    for (int index = 0; index < event.getTriggeringGeofences().size(); index++) {
                        geofenceIds[index] = event.getTriggeringGeofences().get(index).getRequestId();
                    }
                    if (transition == Geofence.GEOFENCE_TRANSITION_ENTER || transition == Geofence.GEOFENCE_TRANSITION_DWELL) {
                        onEnteredGeofences(geofenceIds);
                    } else {
                        onExitedGeofences(geofenceIds);
                    }
                }
            }
        }
    }

    protected void onEnteredGeofences(String[] geofenceIds ) {


        for (String fenceId : geofenceIds) {

            switch (fenceId)
            {
                case "UCLL" :

                    Intent intent = new Intent(this.context, QuestionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("PlaceName", "UCLL");
                    context.startActivity(intent);
                    break;

                case "Home" :

                    Intent intent2 = new Intent(this.context, QuestionActivity.class);
                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent2.putExtra("PlaceName", "Home");
                    context.startActivity(intent2);
                    break;

                case "Plopsa":

                    Intent intent3 = new Intent(this.context, QuestionActivity.class);
                    intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent3.putExtra("PlaceName","Plopsa");
                    context.startActivity(intent3);
                    break;
            }


            Toast.makeText(context, String.format("Entered this fence: %1$s", fenceId), Toast.LENGTH_SHORT).show();
            Log.i(TAG, String.format("Entered this fence: %1$s", fenceId));
            createNotification(fenceId, "Entered");



        }
    }

    protected void onExitedGeofences(String[] geofenceIds){
        for (String fenceId : geofenceIds) {
            Toast.makeText(context, String.format("Exited this fence: %1$s", fenceId), Toast.LENGTH_SHORT).show();
            Log.i(TAG, String.format("Exited this fence: %1$s", fenceId));
            createNotification(fenceId, "Exited");
        }
    }

    protected void onError(int errorCode){
        Toast.makeText(context, String.format("onError(%1$d)", errorCode), Toast.LENGTH_SHORT).show();
        Log.e(TAG, String.format("onError(%1$d)", errorCode));
    }

    /**
     * Create our notification.
     *
     * @param fenceId the name of the Geofence
     * @param fenceState Entered, Exited or Dwell
     */
    private void createNotification(String fenceId, String fenceState) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
        notificationBuilder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder
                .setContentText(fenceId)
                .setContentTitle(String.format("Fence %1$s", fenceState))
                .setSmallIcon(R.drawable.ic_stat_action_room)
                .setColor(Color.argb(0x55, 0x00, 0x00, 0xff))
                .setTicker(String.format("%1$s Fence: %2$s", fenceState, fenceId));
        Intent notificationIntent = new Intent(context, MapsActivity.class);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        notificationIntent.setAction(Intent.ACTION_MAIN);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationManager.notify(R.id.notification, notificationBuilder.build());
    }

}