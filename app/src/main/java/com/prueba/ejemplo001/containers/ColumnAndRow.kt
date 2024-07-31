package com.prueba.ejemplo001.containers

import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyColumn() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Blue)
        )
    }
}


@Composable
fun MyRow() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment  = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(50.dp)
                .height(50.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(50.dp)
                .height(50.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(50.dp)
                .height(50.dp)
                .background(Color.Blue)
        )

    }
}


@Preview(showSystemUi = true)
@Composable
fun ColumnPreview() {
    MyColumn()
}

@Preview(showSystemUi = true)
@Composable
fun RowPreview() {
    MyRow()
}

