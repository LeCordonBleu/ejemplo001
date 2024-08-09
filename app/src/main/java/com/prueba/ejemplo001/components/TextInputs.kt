package com.prueba.ejemplo001.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextInputs() {
    Column {

        var myText by remember { mutableStateOf("") }
        TextField(
            value = myText,
            onValueChange = { myText = it }
        )

        var myText2 by remember { mutableStateOf("") }
        TextField(
            value = myText2,
            onValueChange = {
                myText2 = if (it.contains("c")) {
                    it.replace("c", "")
                } else {
                    it.replace("y", "")
                }
            }
        )

        var myText3 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myText3,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "PlaceHolder")
            },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {}
        )


        var myText4 by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myText4,
            maxLines = 1,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null)},
            trailingIcon = { Icon(imageVector = Icons.Default.Edit, contentDescription = null)},
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = {
                Text(text = "Email address")
            },
            placeholder = {
                Text(text = "Your Email")
            },
            //visualTransformation = PasswordVisualTransformation(),
            onValueChange = {myText4 = it }
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewInputs() {
    TextInputs()
}