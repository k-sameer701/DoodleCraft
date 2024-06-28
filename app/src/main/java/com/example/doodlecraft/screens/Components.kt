package com.example.doodlecraft.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun CustomContainer(
    selectedBackgroundColor: Color,
    onColorChange: () -> Unit,
    contentDescriptionText: String,
    selectedIcon: ImageVector

) {
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .clickable { onColorChange() },
        shape = RoundedCornerShape(10.dp),
        color = selectedBackgroundColor,
        border = BorderStroke(width = 1.dp, color = Color.Black),
        shadowElevation = 2.dp
    ) {
        Icon(
            modifier = Modifier.size(45.dp).padding(2.dp),
            imageVector = selectedIcon,
            contentDescription = contentDescriptionText
        )
    }
}