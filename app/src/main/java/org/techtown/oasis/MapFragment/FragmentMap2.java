package org.techtown.oasis.MapFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.techtown.oasis.HospitalList.Child10.FragmentChild8;
import org.techtown.oasis.R;

public class FragmentMap2 extends Fragment implements OnMapReadyCallback {
    private ViewGroup rootView;
    private FragmentActivity myContext;
    FragmentManager fragmentManger;
    MapFragment mapFragment;
    Button checkButton2;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_map2, container, false);

        fragmentManger = myContext.getFragmentManager();
        mapFragment = (MapFragment) fragmentManger.findFragmentById(R.id.googleMap2);
        mapFragment.getMapAsync(this);

        checkButton2 = rootView.findViewById(R.id.checkButton2);
        checkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentChild8 fragmentChild8 = new FragmentChild8();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentChild8);
                transaction.commit();
            }
        });
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(34.47908458409323, 126.05103752603114);  // 가사도 마을 회관
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("가사도 마을회관");
        markerOptions.snippet("마을회관");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}