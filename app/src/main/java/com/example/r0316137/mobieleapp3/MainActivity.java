package com.example.r0316137.mobieleapp3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    private static final LatLng CHANDLER = new LatLng(33.455,-112.0668);

    private static final StoreLocation[] ALLRESTURANTLOCATIONS = new StoreLocation[]{
            new StoreLocation(new LatLng(33.455, -112.0668), new String("Phoenix, AZ")),
            new StoreLocation(new LatLng(33.5123, -111.9336), new String("SCOTTSDALE, AZ")),
            new StoreLocation(new LatLng(33.3333, -111.8335), new String("Chandler, AZ")),
            new StoreLocation(new LatLng(33.4296, -111.9436), new String("Tempe, AZ")),
            new StoreLocation(new LatLng(33.4152, -111.8315), new String("Mesa, AZ")),
            new StoreLocation(new LatLng(33.3525, -111.7896), new String("Gilbert, AZ"))
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geolocation_view);


        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.storelocationmap)).getMap();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CHANDLER, ZOOM_LEVEL));
        Drawable iconDrawable = getResources().getDrawable(R.drawable.ic_launcher);
        Bitmap iconBmp = ((BitmapDrawable) iconDrawable).getBitmap();
        for (int ix = 0; ix < ALLRESTURANTLOCATIONS.length; ix++) {
            mMap.addMarker(new MarkerOptions()
                    .position(ALLRESTURANTLOCATIONS[ix].mLatLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(iconBmp)));


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
