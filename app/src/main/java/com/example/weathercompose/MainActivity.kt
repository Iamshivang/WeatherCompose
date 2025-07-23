package com.example.weathercompose

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.example.weathercompose.presentation.WeatherScreen
import com.example.weathercompose.presentation.theme.ColorTextPrimary
import com.example.weathercompose.presentation.theme.WeatherComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), LocationListener {

    private val TAG = "MainActivity"
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2
    private var latitude by mutableStateOf<Double?>(null)
    private var longitude by mutableStateOf<Double?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        checkAndRequestPermission()

        setContent {
            WeatherComposeTheme {

                if (latitude != null && longitude != null) {

                    WeatherScreen(
                        lat = latitude!!,
                        lon = longitude!!
                    ){
                        getLocation()
                    }
                } else {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ){

                        Text(
                            text = "Getting location...",
                            color = ColorTextPrimary,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
    }

    private fun checkAndRequestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        } else {

            if(isLocationEnabled()){
                getLocation()
            }else{
                // Go to location settings if GPS is OFF
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    private fun getLocation(){

        // Try to get last known location immediately (faster)
        val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        if (lastKnownLocation != null) {
            latitude = lastKnownLocation.latitude
            longitude = lastKnownLocation.longitude
            Log.d(TAG, "Using last known location: $latitude, $longitude")
        } else {
            // Fall back to waiting for live location updates
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0f, this)
            Log.d(TAG, "Waiting for live GPS update...")
        }
    }

    override fun onLocationChanged(location: Location) {

        latitude = location.latitude
        longitude = location.longitude
        Log.d(TAG, "Latitude: $latitude ,Longitude: $longitude")
        // Stop updates after first location
        locationManager.removeUpdates(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)
        if(requestCode == locationPermissionCode){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                if(isLocationEnabled()){
                    getLocation()
                }else{
                    // Go to location settings if GPS is OFF
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivity(intent)
                }

            }else{
                // Permission denied — go to app permission settings
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        }
    }

    private fun isLocationEnabled(): Boolean {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    override fun onResume() {
        super.onResume()
        checkAndRequestPermission()
    }

}