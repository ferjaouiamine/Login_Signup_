package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Tp31Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        title = "Taper votre nom",
                        login = "login",
                        modifier = Modifier.padding(innerPadding),
                        onLoginClick = { loginValue ->
                            val intent = Intent(this, Tp32Activity::class.java).apply {
                                putExtra("name", loginValue)
                            }
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(title: String, login: String, modifier: Modifier = Modifier, onLoginClick: (String) -> Unit) {
    var loginValue by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = loginValue,
            onValueChange = { loginValue = it }
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { context.startActivity(Intent(context, Tp32Activity::class.java)) },
            modifier = Modifier
                .padding(10.dp)
                .height(55.dp)
                .width(150.dp),
            shape = RectangleShape
        ) {
           // Icon(
         //    Icons.Default.Login,
             //   contentDescription = "Account",
               // modifier = Modifier.size(ButtonDefaults.IconSize)
            //)
            Text("Login", fontSize = 19.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting3("Taper votre nom", "login", onLoginClick = {})
    }
}
