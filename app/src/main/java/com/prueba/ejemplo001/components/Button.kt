package com.prueba.ejemplo001.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prueba.ejemplo001.ui.theme.green200
import com.prueba.ejemplo001.ui.theme.green500

@Composable
fun MyButton() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(
                text = "Buttons",
                style = typography.bodyMedium.copy(
                    color = Color.Blue
                ),
                modifier = Modifier.padding(8.dp)
            )

            Button(onClick = { }) {
                Text(text = "Click me")
            }

            Button(
                onClick = { },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Click me con padding")
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                enabled = false
            ) {
                Text(
                    text = "Texto Disabled"
                )
            }

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "OutlinedButton")
            }

            Row {
                Button(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Icon Favorito",
                        modifier = Modifier.padding(2.dp)
                    )

                    Text(
                        text = "Favorito"
                    )
                }

                val outlinedButtonColor = ButtonDefaults.outlinedButtonColors(
                    contentColor = green200
                )

                val mainButtonColor = ButtonDefaults.buttonColors(
                    contentColor = green200,
                    containerColor = green500,
                    )

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    colors = outlinedButtonColor,
                ) {
                    Text(text = "Outline Color")
                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = mainButtonColor
                ) {
                    Text(text = "Button color")
                }

            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun MyButtonPreview() {
    MyButton()
}