package com.example.r0316137.mobieleapp3;

/*import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

*//**
 * Created by Tom on 16/11/2015.
 *//*
public class GeofenceController {

    private final String TAG = GeofenceController.class.getName();

    private Context context;
    private GoogleApiClient googleApiClient;
    private Gson gson;
    private SharedPreferences prefs;

    private List<NamedGeofence> namedGeofences;
    public List<NamedGeofence> getNamedGeofences() {
        return namedGeofences;
    }

    private List<NamedGeofence> namedGeofencesToRemove;

    private Geofence geofenceToAdd;
    private NamedGeofence namedGeofenceToAdd;

    private static GeofenceController INSTANCE;





    public static GeofenceController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeofenceController();
        }
        return INSTANCE;
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();

        gson = new Gson();
        namedGeofences = new ArrayList<>();
        namedGeofencesToRemove = new ArrayList<>();
        prefs = this.context.getSharedPreferences(SyncStateContract.Constants.SharedPrefs.Geofences, Context.MODE_PRIVATE);
    }*/





