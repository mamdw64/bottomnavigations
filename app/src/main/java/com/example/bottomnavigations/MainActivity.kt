package com.example.bottomnavigations

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigations.ui.theme.BottomnavigationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            bottomnavigations {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController)}) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = Login.Route ){
                composable(Login.Route){
                    login(navController)
                }
                composable(Welcome.Route){
                    Welcome
                }
            }
        }
    }
}
