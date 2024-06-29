package com.example.doodlecraft.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doodlecraft.R
import com.example.doodlecraft.data.Line

@Preview(showSystemUi = true)
@Composable
fun DrawingScreen() {
    val currentLines = remember { mutableStateListOf<Line>() }
    var currentColor by remember { mutableStateOf(Color.White) }
    var isDialog by remember { mutableStateOf(false) }

    var themeColor by remember { mutableStateOf(Color.Black) }
    var isThemeChange by remember { mutableStateOf(false) }

    var strokeWidthSlider by remember { mutableStateOf(10f) }

    if(isDialog ) {
        AlertDialog(
            modifier = Modifier
                .height(500.dp),
            onDismissRequest = {
                isDialog = false
            },
            confirmButton = {
                Column {
                    Text(
                        text = "Select Color",
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ColorContainer(
                            selectedBackgroundColor = Color(255, 0, 0),
                            onColorChange = {
                                currentColor = Color(255, 0, 0)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(255, 165, 0),
                            onColorChange = {
                                currentColor = Color(255, 165, 0)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(255, 255, 0),
                            onColorChange = {
                                currentColor = Color(255, 255, 0)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(0, 128, 0),
                            onColorChange = {
                                currentColor = Color(0, 128, 0)
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ColorContainer(
                            selectedBackgroundColor = Color(0, 255, 255),
                            onColorChange = {
                                currentColor = Color(0, 255, 255)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(0, 0, 255),
                            onColorChange = {
                                currentColor = Color(0, 0, 255)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(128, 0, 128),
                            onColorChange = {
                                currentColor = Color(128, 0, 128)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(255, 192, 203),
                            onColorChange = {
                                currentColor = Color(255, 192, 203)
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ColorContainer(
                            selectedBackgroundColor = Color(165, 42, 42),
                            onColorChange = {
                                currentColor = Color(165, 42, 42)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(0, 0, 0),
                            onColorChange = {
                                currentColor = Color(0, 0, 0)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(255, 255, 255),
                            onColorChange = {
                                currentColor = Color(255, 255, 255)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(128, 128, 128),
                            onColorChange = {
                                currentColor = Color(128, 128, 128)
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ColorContainer(
                            selectedBackgroundColor = Color(211, 211, 211),
                            onColorChange = {
                                currentColor = Color(211, 211, 211)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color.Magenta,
                            onColorChange = {
                                currentColor = Color.Magenta
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(144, 238, 144),
                            onColorChange = {
                                currentColor = Color(144, 238, 144)
                            }
                        ) {
                            isDialog = false
                        }
                        ColorContainer(
                            selectedBackgroundColor = Color(173, 216, 230),
                            onColorChange = {
                                currentColor = Color(173, 216, 230)
                            }
                        ) {
                            isDialog = false
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Slider(
                        value = strokeWidthSlider,
                        onValueChange = { strokeWidthSlider = it },
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.secondary,
                            activeTrackColor = MaterialTheme.colorScheme.secondary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                        steps = 100,
                        valueRange = 10f..50f
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Button(onClick = {
                            isDialog = false
                        }
                        ) {
                            Text(text = "Cancel")
                        }
                        Button(onClick = {
                            isDialog = false
                        }
                        ) {
                            Text(text = "Done")
                        }
                    }
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColor),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            MainContainer(
                contentDescriptionText = "Pen",
                selectedIcon = R.drawable.pencil
            ) {
                isDialog = !isDialog
            }
            MainContainer(
                contentDescriptionText = "Eraser",
                selectedIcon = R.drawable.eraser
            ) {
                currentColor = themeColor
            }
            IconButton(
                onClick = {
                    currentLines.clear()
                }
            ) {
                Image(painter = painterResource(id = R.drawable.broom), contentDescription = "Clean")
            }
            IconButton(
                onClick = {
                    isThemeChange = !isThemeChange

                }
            ) {
                themeColor = if (isThemeChange) {
                    Image(painter = painterResource(id = R.drawable.night), contentDescription = "Dark")
                    Color.White
                } else {
                    Image(painter = painterResource(id = R.drawable.sun), contentDescription = "Light")
                    Color.Black
                }
            }
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(themeColor)
                .pointerInput(true) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val currentLine = Line(
                            start = change.position - dragAmount,
                            end = change.position,
                            color = currentColor,
                            strokeWidth = strokeWidthSlider
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
                    strokeWidth = currentLine.strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}