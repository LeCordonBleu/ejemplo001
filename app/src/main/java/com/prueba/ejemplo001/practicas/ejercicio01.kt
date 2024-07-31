package com.prueba.ejemplo001.practicas

import android.R.style
import android.content.res.Resources.Theme
import android.graphics.Paint.Style
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.ejemplo001.R
import com.prueba.ejemplo001.ui.theme.Ejemplo001Theme
import com.prueba.ejemplo001.ui.theme.green200
import com.prueba.ejemplo001.ui.theme.green500


@Composable
fun Ejercicio01(darkTheme: Boolean = isSystemInDarkTheme()) {


    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,

        ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.compose_header),
                contentDescription = "header",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.avatar00),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )

                Text(
                    text = "Bienvenido al curos de Jetpack Compose",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

            }

            Divider(
                thickness = 0.5.dp,
                color = Color.Black,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            )

            Text(
                text = "Aquí encontraras toda la informacion necesaria para aprender a como utilizar esta herramienta declarativa para realizar Interfaces",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontStyle = FontStyle.Italic
                )
            )


            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = green500,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(4.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Black
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Icon Favorito",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Empesar")
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )

                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Encuentranos en nuestras redes sociales",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontStyle = FontStyle.Normal
                        )
                    )

                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(280.dp)
                        .height(45.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Blue
                    ),
                    border = BorderStroke(
                        width = 1.5.dp,
                        color = Color.Blue
                    )
                ) {
                    Text(
                        text = "Facebook",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(280.dp)
                        .height(45.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Red
                    ),
                    border = BorderStroke(
                        width = 1.5.dp,
                        color = Color.Red
                    )
                ) {
                    Text(
                        text = "Gmail",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }


        }
    }

    if (darkTheme) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_negativo),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(bottom = 10.dp),
                contentScale = ContentScale.Fit
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_normal),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(bottom = 10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }


}

@Preview(showSystemUi = true, name = "Light Mode")
@Composable
fun Ejercicio01Preview() {
    Ejemplo001Theme(darkTheme = false) {
        Ejercicio01(false)
    }
}

@Preview(showSystemUi = true, name = "Dark Mode")
@Composable
fun Ejercicio01PreviewDark() {
    Ejemplo001Theme(darkTheme = true) {
        Ejercicio01(true)
    }
}