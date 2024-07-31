package com.prueba.ejemplo001.components

import android.graphics.Paint.Style
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

        Column() {
            Text(
                text = "My first text",
                color = Color.White,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(10.dp)
            )

            val offset = Offset(5.0f, 10.0f)

            Text(
                text = "Hello",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(
                        color = Color.Blue,
                        blurRadius = 3f,
                        offset = offset
                    )
                ),
                fontFamily = FontFamily.SansSerif
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(10.dp),
                text = buildAnnotatedString {
                    append("Acceptar los")

                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append(" terminos y condiciones ")
                    }

                    append(" descritos")

                }
            )



            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(10.dp),
                text = "Hello word",
                letterSpacing = 5.sp,
                textDecoration = TextDecoration.LineThrough
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(10.dp),
                text = " Hello word",
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,

                style = MaterialTheme.typography.displayMedium.copy(
                    shadow = Shadow(
                        offset = Offset(5f, 5f),
                        blurRadius = 5f,
                        color = Color.Black.copy(
                            alpha = 0.5f
                        )
                    )
                ),
            )

        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun MyTextPreview() {
    MyText()
}