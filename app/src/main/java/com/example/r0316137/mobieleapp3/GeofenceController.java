package com.example.r0316137.mobieleapp3;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Tom on 16/11/2015.
 */
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
}

