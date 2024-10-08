package com.prueba.ejemplo001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prueba.ejemplo001.components.PokemonList
import com.prueba.ejemplo001.components.PokemonListWithDataClass
import com.prueba.ejemplo001.components.PokemonListWithState
import com.prueba.ejemplo001.components.TextInputs
import com.prueba.ejemplo001.concepts.Answer
import com.prueba.ejemplo001.concepts.SingleChoiseQuestion
import com.prueba.ejemplo001.concepts.SurveyAnswer
import com.prueba.ejemplo001.practicas.Ejercicio01
import com.prueba.ejemplo001.practicas.SignInScreen
import com.prueba.ejemplo001.practicasEjm.ListAsistencia
import com.prueba.ejemplo001.ui.theme.Ejemplo001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo001Theme {
                ListAsistencia()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}

@Preview(showSystemUi = true, name = "Hello Compose")
@Composable
fun GreetingPreview() {
    Greeting(name = "Fernando Celestino")
}

