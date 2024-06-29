package com.example.doodlecraft.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.substring
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doodlecraft.R
import com.example.doodlecraft.data.Line



//@Preview(showSystemUi = true)
@Composable
fun DrawingScreen() {
    val currentLines = remember { mutableStateListOf<Line>() }
    var currentColor by remember { mutableStateOf(Color.Black) }
    var isDialog by remember { mutableStateOf(false) }

    var strokeWidthSlider by remember { mutableStateOf(0f) }

    if(isDialog) {
        AlertDialog(
            modifier = Modifier.height(500.dp),
            onDismissRequest = { isDialog = false },
            confirmButton = {
                Column {
                    Row {
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Green,
                            onColorChange = {
                                currentColor = Color.Green
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Red,
                            onColorChange = {
                                currentColor = Color.Red
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Magenta,
                            onColorChange = {
                                currentColor = Color.Magenta
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Blue,
                            onColorChange = {
                                currentColor = Color.Blue
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Yellow,
                            onColorChange = {
                                currentColor = Color.Yellow
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Row {
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Green,
                            onColorChange = {
                                currentColor = Color.Green
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Red,
                            onColorChange = {
                                currentColor = Color.Red
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Magenta,
                            onColorChange = {
                                currentColor = Color.Magenta
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Blue,
                            onColorChange = {
                                currentColor = Color.Blue
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Yellow,
                            onColorChange = {
                                currentColor = Color.Yellow
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Row {
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Green,
                            onColorChange = {
                                currentColor = Color.Green
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Red,
                            onColorChange = {
                                currentColor = Color.Red
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Magenta,
                            onColorChange = {
                                currentColor = Color.Magenta
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Blue,
                            onColorChange = {
                                currentColor = Color.Blue
                            }
                        ) {
                            isDialog = false
                        }
                        PenCustomContainer(
                            selectedBackgroundColor = Color.Yellow,
                            onColorChange = {
                                currentColor = Color.Yellow
                            }
                        ) {
                            isDialog = false
                        }
                    }

                    Slider(
                        value = strokeWidthSlider,
                        onValueChange = { strokeWidthSlider = it },
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.secondary,
                            activeTrackColor = MaterialTheme.colorScheme.secondary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                        steps = 100,
                        valueRange = 0f..10f
                    )
                    Text(text = strokeWidthSlider.toString())
                    Text(
                        modifier = Modifier.clickable {
                            isDialog = false
                        },
                        text = "Done"
                    )

                }
            }
        )
    }

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
            MainContainer(
                contentDescriptionText = "Pencil",
                selectedIcon = R.drawable.pencil
            ) {
                isDialog = !isDialog
            }
            MainContainer(
                contentDescriptionText = "Eraser",
                selectedIcon = R.drawable.eraser
            ) {
                isDialog = !isDialog
            }
            MainContainer(
                contentDescriptionText = "Pen",
                selectedIcon = R.drawable.technical_pen
            ) {
                isDialog = !isDialog
            }
            MainContainer(
                contentDescriptionText = "Clean",
                selectedIcon = R.drawable.broom
            ) {
                isDialog = !isDialog
            }

            Button(onClick = {currentLines.clear()}) {
                MainContainer(
                    contentDescriptionText = "Clean",
                    selectedIcon = R.drawable.broom
                ) {
                    isDialog = !isDialog
                }
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
                            color = currentColor,
                            strokeWidth = strokeWidthSlider.dp
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

//@Preview(showSystemUi = true)
//@Composable
//fun SliderAdvancedExample() {
//    var sliderPosition by remember { mutableStateOf(0f) }
//    Column {
//        Slider(
//            value = sliderPosition,
//            onValueChange = { sliderPosition = it },
//            colors = SliderDefaults.colors(
//                thumbColor = MaterialTheme.colorScheme.secondary,
//                activeTrackColor = MaterialTheme.colorScheme.secondary,
//                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
//            steps = 100,
//            valueRange = 0f..10f
//        )
//        Text(text = sliderPosition.toString())
//    }
//}
