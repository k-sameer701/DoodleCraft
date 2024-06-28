package com.example.doodlecraft.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doodlecraft.data.Line


@Preview(showSystemUi = true)
@Composable
fun DrawingScreen() {
    val currentLines = remember { mutableStateListOf<Line>() }
    var currentColor by remember { mutableStateOf(Color.Black) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(3.dp)
        ) {
            CustomContainer(
                selectedBackgroundColor = Color.Yellow,
                onColorChange = {
                    currentColor = Color.Yellow
                },
                contentDescriptionText = "Yellow",
                selectedIcon = Icons.Default.Create
            )
            CustomContainer(
                selectedBackgroundColor = Color.Green,
                onColorChange = {
                    currentColor = Color.Green
                },
                contentDescriptionText = "Green",
                selectedIcon = Icons.Default.Create
            )
            CustomContainer(
                selectedBackgroundColor = Color.Red,
                onColorChange = {
                    currentColor = Color.Red
                },
                contentDescriptionText = "Red",
                selectedIcon = Icons.Default.Create
            )


            Button(onClick = {currentLines.clear()}) {
                Text(text = "Clear")
            }

        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(true) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()

                        val currentLine = Line(
                            start = change.position - dragAmount,
                            end = change.position,
                            color = currentColor
                        )
                        currentLines.add(currentLine)
                    }
                }
        ) {
            currentLines.forEach { currentLine ->
                drawLine(
                    start = currentLine.start,
                    end = currentLine.end,
                    color = currentLine.color,
                    strokeWidth = currentLine.strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )
            }

        }
    }

}