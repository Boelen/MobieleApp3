package com.example.r0316137.mobieleapp3;

import com.google.android.gms.location.Geofence;

import java.util.UUID;

/**
 * Created by Tom on 16/11/2015.
 */
public class NamedGeofence {

    public Geofence geofence() {
        id = UUID.randomUUID().toString();
        return new Geofence.Builder()
                .setRequestId(id)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                .setCircularRegion(latitude, longitude, radius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .build();
    }
}
