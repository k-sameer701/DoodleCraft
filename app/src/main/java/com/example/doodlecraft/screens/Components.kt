package com.example.doodlecraft.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ColorContainer(
    selectedBackgroundColor: Color,
    onColorChange: () -> Unit,
    isDialog: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onColorChange()
                isDialog()
            },
        color = selectedBackgroundColor,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp
    ) {
        Text(
            modifier = Modifier
                .size(55.dp)
                .padding(10.dp),
            text = ".",
            color = selectedBackgroundColor
        )
    }
}

@Composable
fun MainContainer(
    contentDescriptionText: String,
    selectedIcon: Int,
    isDialog: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .clickable {
                isDialog()
            },
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 2.dp
    ) {
        Image(
            modifier = Modifier
                .size(45.dp)
                .padding(5.dp),
            painter = painterResource(id = selectedIcon),
            contentDescription = contentDescriptionText
        )
    }
}