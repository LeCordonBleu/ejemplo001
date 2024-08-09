package com.prueba.ejemplo001.concepts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen() {

    var quantity by rememberSaveable { mutableStateOf(0) }

    CounterContent(
        quantity = quantity,
        onAddClicked = {
            quantity++
        },
        onRemoveClicked = {
            quantity--
        }
    )
}

@Composable
fun CounterContent(
    quantity: Int,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit
) {


    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(onClick = { onAddClicked() }) {
            Text(text = "+")
        }
        Divider(modifier = Modifier.width(16.dp))
        Text(text = "${quantity}")
        Divider(modifier = Modifier.width(16.dp))
        Button(onClick = { onRemoveClicked() }) {
            Text(text = "-")
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun CounterContentPreview() {
    CounterScreen()
}