package com.example.r0316137.mobieleapp3;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Tom on 28/11/2015.
 */
public class MyPlaces {

    private String title;
    private String snippet;
    private LatLng coordinates;
    private float fenceRadius;
    private int iconResourceId;
    private float defaultZoomLevel;

    public MyPlaces(String title, String snippet, LatLng coordinates, float fenceRadius, int defaultZoomLevel, int iconResourceId) {
        this.title = title;
        this.snippet = snippet;
        this.coordinates = coordinates;
        this.fenceRadius = fenceRadius;
        this.defaultZoomLevel = defaultZoomLevel;
        this.iconResourceId = iconResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public float getFenceRadius() {
        return fenceRadius;
    }

    public float getDefaultZoomLevel() {
        return defaultZoomLevel;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

}
