package com.lasalle.peliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lasalle.peliculas.navigation.AppNavigation
import com.lasalle.peliculas.ui.theme.PeliculasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // IA generated: Main entry point using the defined theme and navigation
            PeliculasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // IA generated: Using a Box to apply the Scaffold padding
                    Box(modifier = Modifier.padding(innerPadding)) {
                        // IA generated: Call AppNavigation to handle screen routing
                        AppNavigation()
                    }
                }
            }
        }
    }
}
