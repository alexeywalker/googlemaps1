package com.example.googlemaps1.domain

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

class Permissions {

    @ExperimentalPermissionsApi
    @Composable
    fun Permission() {
        val permissionsState = rememberMultiplePermissionsState(
            permissions = listOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            )
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(
                key1 = lifecycleOwner,
                effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_RESUME) {
                            permissionsState.launchMultiplePermissionRequest()
                        }
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)

                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                })
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                permissionsState.permissions.forEach { perm ->
                    when (perm.permission) {
                        Manifest.permission.ACCESS_COARSE_LOCATION -> {
                            when {
                                perm.status.isGranted -> {
                                    Text(text = "Location permissions accepted")
                                }
                                perm.status.shouldShowRationale -> {
                                    Text(
                                        text = "Location permissions needed" +
                                                "to access"
                                    )
                                }
                            }
                        }
                        Manifest.permission.ACCESS_FINE_LOCATION -> {
                            when {
                                perm.status.isGranted -> {
                                    Text(text = "Location permissions accepted")
                                }
                                perm.status.shouldShowRationale -> {
                                    Text(
                                        text = "Location permissions needed" +
                                                "to access"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
