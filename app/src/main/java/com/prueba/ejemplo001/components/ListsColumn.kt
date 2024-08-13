package com.prueba.ejemplo001.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Stairs
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.prueba.ejemplo001.ui.theme.CodidevDark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class Pokemon(
    val id: Int,
    val name: String,
    val image: String,
    val hasDetail: Boolean,
    val type: String,
)

fun getPokemons() = (1..150).map {
    Pokemon(
        id = it,
        name = "Pokemon $it",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$it.png",
        hasDetail = it % 3 == 0,
        type = if (it in 1..49) "Fuego" else if (it in 50..100) "Planta" else "Agua"
    )
}

@Composable
fun PokemonList() {

    LazyColumn() {
        items(150) {
            PokemonItem()
        }
    }
}

@Composable
fun PokemonItem() {

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png")
                    .crossfade(2000)
                    .build(),
                contentDescription = "Pokemon",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Inside
            )
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = "Go to Detail",
                tint = Color.Black,
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.CenterEnd)
            )

        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CodidevDark)
                .padding(16.dp)
        ) {
            Text(
                text = "Pokemon",
                //style = MaterialTheme.typography.h5
                color = Color.White
            )
        }
    }
}


@Composable
fun PokemonListWithDataClass() {
    val context = LocalContext.current
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Listado de Pokemons",
                    style = TextStyle(
                        color = CodidevDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        items(getPokemons()) { pokemon ->
            PokemonItemWithDataClass(pokemon) {
                Toast.makeText(context, "${pokemon.name}", Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun PokemonListWithState() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    LazyColumn(
        state = rvState,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Listado de Pokemons",
                    style = TextStyle(
                        color = CodidevDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }


        items(getPokemons()) { pokemon ->
            PokemonItemWithDataClass(pokemon) {
                Toast.makeText(context, "${pokemon.name}", Toast.LENGTH_LONG).show()
            }
        }
    }

    val showFab by remember {
        derivedStateOf {
            rvState.firstVisibleItemIndex > 0
        }
    }

    Log.v("showFab", showFab.toString())

    if (showFab) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    end = 8.dp, bottom = 8.dp
                )
        ) {
            MyFab(rvState, coroutinesScope)
        }
    }

}


@Composable
fun MyFab(rvState: LazyListState, coroutinesScope: CoroutineScope) {
    FloatingActionButton(onClick = {
        coroutinesScope.launch {
            rvState.animateScrollToItem(0)
        }
    }) {
        Icon(imageVector = Icons.Default.Stairs, contentDescription = "Go to")
    }
}

@Composable
fun PokemonItemWithDataClass(
    pokemon: Pokemon,
    onItemSelected: (Pokemon) -> Unit,
) {

    Card(
        border = BorderStroke(1.dp, Color.Black),
//        elevation = ,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .clickable {
                onItemSelected(pokemon)
            }
    ) {
        Column(

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.image)
                        .crossfade(2000)
                        .build(),
                    contentDescription = pokemon.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Inside
                )
                if (pokemon.hasDetail) {
                    Icon(
                        imageVector = Icons.Default.NavigateNext,
                        contentDescription = "Go to Detail",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.CenterEnd)
                    )
                }


            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CodidevDark)
                    .padding(16.dp)
            ) {
                Text(
                    text = pokemon.name,
                    //style = MaterialTheme.typography.h5
                    color = Color.White
                )
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PokemonListPreview() {
    PokemonListWithState()
}

