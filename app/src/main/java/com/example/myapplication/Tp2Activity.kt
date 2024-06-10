package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class Tp2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LayoutDesign()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutDesign2() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("First Drwer")
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                NavigationDrawerItem(
                    label = { Text("TP0") },
                    selected = true,
                    onClick = { /*TODO*/ })
                NavigationDrawerItem(
                    label = { Text("TP1") },
                    selected = true,
                    onClick = { /*TODO*/ })
                NavigationDrawerItem(
                    label = { Text("TP2") },
                    selected = true,
                    onClick = { /*TODO*/ })
                NavigationDrawerItem(
                    label = { Text("TP3") },
                    selected = true,
                    onClick = { /*TODO*/ })
                NavigationDrawerItem(
                    label = { Text("TP4") },
                    selected = true,
                    onClick = { /*TODO*/ })
            }
        })
    {

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                    ),

                    title = { Text("My Application") },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            tint = Color.Black,
                            contentDescription = "Menu",
                            modifier = Modifier.clickable {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open()
                                    }
                                }
                            }

                        )
                    })
            },
            bottomBar = {},
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")

                }
            }


        ) { innerPadding ->
            Greeting2(name = "world !!", modifier = Modifier.padding(innerPadding))
        }
    }
}


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LayoutDesign2Preview() {
    MyApplicationTheme {
        LayoutDesign()
    }
}