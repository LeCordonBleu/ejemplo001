package com.prueba.ejemplo001.concepts


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prueba.ejemplo001.R

data class Answer(
    val title: String,
    val image: Int,
)

@Composable
fun SingleChoiseQuestion(answer: List<Answer>) {

    //var selected by remember {
    //    mutableStateOf(false)
    //}

    var selectedAnswer: Answer? by remember {
        mutableStateOf(null)
    }

    Column() {

        answer.forEach { answer ->
            SurveyAnswer(
                answer,
                selected = answer == selectedAnswer,
                onSelected = { selected ->
                    selectedAnswer = selected
                }
            )
        }

    }
}

@Composable
fun SurveyAnswer(
    answer: Answer,
    selected: Boolean = false,
    onSelected: (Answer) -> Unit
) {

    Box(
        modifier = Modifier
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.DarkGray))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = answer.image),
                contentDescription = "Avatar"
            )

            Text(text = answer.title)
            RadioButton(selected = selected, onClick = { onSelected(answer) })
        }
    }
}


@Preview(widthDp = 300)
@Composable
fun SurveyAnswerPreview() {
    SingleChoiseQuestion(
        listOf(
            Answer(
                title = "Dog",
                image = R.drawable.avatar00
            ),
            Answer(
                title = "Cat",
                image = R.drawable.avatar00
            )
        )

    );
}