package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.components.MyDateDialog
import com.example.myapplication.components.MyModalDrawer
import com.example.myapplication.components.MyTimePicker
import com.example.myapplication.components.ScrollList
import com.example.myapplication.components.advance.InteractionSourceExample
import com.example.myapplication.components.advance.MyLaunchedEffect
import com.example.myapplication.components.navigation.NavigationWrapper
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                NavigationWrapper()
//                MyTimePicker()

/*                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {},
                    snackbarHost = { SnackbarHost(snackbarHostState) }) { innerPadding ->

                    MyModalDrawer(innerPadding) {
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ScrollList()

//                            Text("Esta es mi screen", modifier = Modifier.clickable {
//                                scope.launch {
//                                    val result = snackbarHostState.showSnackbar(
//                                        message = "Ejemplo",
//                                        actionLabel = "Deshacer"
//                                    )
//
//                                    if (result == SnackbarResult.ActionPerformed) {
//
//                                    }
//                                }
//                            })
//                            InteractionSourceExample()
//                            MyLaunchedEffect {  }
                        }
                    }
                }*/
            }
        }
    }
}