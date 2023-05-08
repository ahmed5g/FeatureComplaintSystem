package tn.pidev.FeatureComplaintSystem.Domain;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.*;

import java.io.IOException;


import java.io.IOException;

public class GoogleMapsAPI {
    private GeoApiContext context;

    public void GoogleMapsApi(String apiKey) {
        context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public GoogleMapsAPI(GeoApiContext context) {
        this.context = context;
    }

    public LatLng geocode(String address) throws ApiException, InterruptedException, IOException {
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        if (results.length > 0) {
            return results[0].geometry.location;
        } else {
            throw new IllegalArgumentException("Unable to geocode address: " + address);
        }
    }

    public String reverseGeocode(double lat, double lng) throws ApiException, InterruptedException, IOException {
        LatLng location = new LatLng(lat, lng);
        GeocodingResult[] results = GeocodingApi.reverseGeocode(context, location).await();
        if (results.length > 0) {
            return results[0].formattedAddress;
        } else {
            throw new IllegalArgumentException("Unable to reverse geocode location: " + location.toString());
        }
    }

    /*public String reverseGeocode(double lat, double lng, double radius) throws ApiException, InterruptedException, IOException {
        LatLng location = new LatLng(lat, lng);
        double radiusInMeters = radius * 1000.0;
        LatLngBounds bounds = LatLngBounds.builder()
                .include(SphericalUtil.computeOffset(location, radiusInMeters, 225))
                .include(SphericalUtil.computeOffset(location, radiusInMeters, 45))
                .build();
        GeocodingResult[] results = GeocodingApi.reverseGeocode(context, location)
                .bounds(bounds)
                .await();
        if (results.length > 0) {
            return results[0].formattedAddress;
        } else {
            throw new IllegalArgumentException("Unable to reverse geocode location: " + location.toString());
        }
    }*/
}
