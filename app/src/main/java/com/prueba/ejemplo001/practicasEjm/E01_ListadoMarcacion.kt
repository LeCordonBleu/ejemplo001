package com.prueba.ejemplo001.practicasEjm

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.ejemplo001.ui.theme.Rajdhani
import com.prueba.ejemplo001.ui.theme.Yellow800
import com.prueba.ejemplo001.ui.theme.azulSAA
import com.prueba.ejemplo001.ui.theme.borderColor
import com.prueba.ejemplo001.ui.theme.green800
import com.prueba.ejemplo001.ui.theme.tansparenteSAA
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale


data class Marcacion(
    val id: Int,
    val fecha_asis: String,
    val hora: String,
    val tipo_marcacion_nombre: String,
    val acceso: String,
    /*val origen_nombre:String,
    val id_pers_det:String,
    val nombres:String*/
)

var fechaTemp = ""
var cont = 0

fun getMarcacion() = listOf(
    Marcacion(
        id = 0,
        fecha_asis = "2024-08-13",
        hora = "07:22:50:000",
        tipo_marcacion_nombre = "MARCACIÓN PRESENCIAL",
        acceso = "IN"
    ),
    Marcacion(
        id = 1,
        fecha_asis = "2024-08-12",
        hora = "18:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN PRESENCIAL",
        acceso = "OUT"
    ),
    Marcacion(
        id = 2,
        fecha_asis = "2024-08-12",
        hora = "08:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN PRESENCIAL",
        acceso = "IN"
    ),
    Marcacion(
        id = 3,
        fecha_asis = "2024-08-09",
        hora = "18:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "OUT"
    ),
    Marcacion(
        id = 4,
        fecha_asis = "2024-08-09",
        hora = "08:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "IN"
    ),
    Marcacion(
        id = 5,
        fecha_asis = "2024-08-08",
        hora = "08:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "IN"
    ),
    Marcacion(
        id = 6,
        fecha_asis = "2024-08-07",
        hora = "18:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "IN"
    ), Marcacion(
        id = 6,
        fecha_asis = "2024-08-07",
        hora = "17:55:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "OUT"
    ),
    Marcacion(
        id = 7,
        fecha_asis = "2024-08-07",
        hora = "08:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "IN"
    ),
    Marcacion(
        id = 8,
        fecha_asis = "2024-08-06",
        hora = "18:15:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "OUT"
    ),
    Marcacion(
        id = 9,
        fecha_asis = "2024-08-06",
        hora = "08:02:50:000",
        tipo_marcacion_nombre = "MARCACIÓN REMOTA",
        acceso = "IN"
    )
)

fun countRegistrosByFecha(fecha: String, marcaciones: List<Marcacion>): Int {
    return marcaciones.count { it.fecha_asis == fecha }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListAsistencia() {
    val context = LocalContext.current

    val marcaciones = remember { getMarcacion() }
    var searchText by remember { mutableStateOf("") }
    val filteredMarcaciones = remember(searchText, marcaciones) {
        marcaciones.filter { marcacion ->
            marcacion.fecha_asis.contains(searchText, ignoreCase = true) ||
                    marcacion.hora.contains(searchText, ignoreCase = true) ||
                    marcacion.tipo_marcacion_nombre.contains(searchText, ignoreCase = true) ||
                    marcacion.acceso.contains(searchText, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(8.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Buscar") },
                modifier = Modifier.width(200.dp)
            )
        }
        // Scroll vertical para los items
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Ocupa el espacio restante
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 3.dp), // Margen vertical
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            items(getMarcacion()) { marcacion ->
                ItemAsistencia(marcacion) {
                    Toast.makeText(context, "${marcacion.fecha_asis}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ItemAsistencia(
    marcacion: Marcacion,
    onItemSelected: (Marcacion) -> Unit,
) {

    val fechaHora = marcacion.fecha_asis + " " + marcacion.hora.substring(0, 5)
    val fechaSola = fechaHora.split(" ")[0]

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val localDateTime = LocalDate.parse(fechaHora, formatter)
        .atTime(LocalTime.parse(fechaHora.split(" ")[1], DateTimeFormatter.ofPattern("HH:mm")))
    val mes = localDateTime.month.getDisplayName(
        java.time.format.TextStyle.FULL,
        Locale.forLanguageTag("es")
    )
    val dia = localDateTime.dayOfMonth.toString()
    val diaNom = localDateTime.dayOfWeek.getDisplayName(
        java.time.format.TextStyle.FULL,
        Locale.forLanguageTag("es")
    )
    val horaFormato = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"))
    var tipo_asistencia = ""
    if (marcacion.acceso == "IN") {
        tipo_asistencia = "E"
    } else {
        tipo_asistencia = "S"
    }


    if (fechaTemp != fechaSola) {
        val marcaciones = getMarcacion()
        val cantidadRegistros = countRegistrosByFecha(fechaSola, marcaciones)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (cantidadRegistros != 1) {
                        tansparenteSAA
                    } else {
                        azulSAA
                    }
                )
                .padding(5.dp)
        ) {
            Log.v("cantidadRegistros", cantidadRegistros.toString())
            Text(
                text = fechaSola,
                color = if (cantidadRegistros != 1) {
                    MaterialTheme.colorScheme.onBackground
                } else {
                    Color.White
                },
                fontFamily = Rajdhani,
                fontSize = 13.sp
            )
        }
        fechaTemp = fechaSola
    }

    Box(
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(5.dp)) // Add shadow
            .height(75.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(0.5.dp, borderColor, RoundedCornerShape(5.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            Column(
                modifier = Modifier
                    .width(75.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(top = 7.dp, bottom = 7.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center


            ) {
                Text(
                    text = "" + mes,//marcacion.fecha_mes,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = dia,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = horaFormato,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }



            Column(
                modifier = Modifier.width(200.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = marcacion.tipo_marcacion_nombre,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 18.sp,
                        fontFamily = Rajdhani,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = diaNom,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Rajdhani,
                    )
                )
            }

            Box(
                modifier = Modifier
                    //.fillMaxWidth(0.5f)
                    .width(60.dp)
                    .padding(8.dp)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(5.dp))
                    .border(0.1.dp, Color.Gray, RoundedCornerShape(5.dp))
                    .background(
                        color = if (tipo_asistencia == "E") {
                            green800
                        } else {
                            Yellow800
                        },
                        shape = RoundedCornerShape(5.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tipo_asistencia,
                    color = Color.White,
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Rajdhani
                )
            }

        }

    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun listaAsistenciaPreview() {
    ListAsistencia()
}
