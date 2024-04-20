package com.example.appaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaula.ui.theme.AppaulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppaulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}
@Composable
fun App(){
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()

    ) {
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.Center
        ) {
                Text(text = "App Aula",
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
            )
        }
        Row(
            Modifier
                .padding(8.dp)
        ) {

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Text(text = "Giovana Marsigli")

            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar")
                }
            }
            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir")
                }
            }
        }
        Row(
            Modifier
                .padding(8.dp)
        ) {

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Text(text = "Larissa Marsigli")

            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar")
                }
            }
            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir")
                }
            }
        }
    }
}

@Composable
@Preview
fun AppPreview (){
    AppaulaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }

}
