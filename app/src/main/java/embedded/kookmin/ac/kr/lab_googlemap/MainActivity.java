package embedded.kookmin.ac.kr.lab_googlemap;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends Activity {

    //LatLng currunt;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);

        Location currunt = map.getMyLocation();
        if(currunt != null){
            LatLng location = new LatLng(currunt.getLatitude(), currunt.getLongitude());
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
            map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        }
    }

}
