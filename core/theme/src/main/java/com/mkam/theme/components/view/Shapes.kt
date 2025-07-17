package com.mkam.theme.components.view

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CustomBottomBarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width * 0.324f, height * 0.193f)
            cubicTo(
                width * 0.178f, height * 0.205f,
                width * 0.047f, height * 0.069f,
                0f, 0f
            )
            lineTo(0f, height)
            lineTo(width, height)
            lineTo(width, 0f)
            cubicTo(
                width * 0.928f, height * 0.184f,
                width * 0.738f, height * 0.189f,
                width * 0.681f, height * 0.189f
            )
            cubicTo(
                width * 0.625f, height * 0.189f,
                width * 0.613f, height * 0.217f,
                width * 0.613f, height * 0.297f
            )
            cubicTo(
                width * 0.613f, height * 0.377f,
                width * 0.625f, height * 0.624f,
                width * 0.554f, height * 0.627f
            )
            cubicTo(
                width * 0.415f, height * 0.688f,
                width * 0.388f, height * 0.521f,
                width * 0.386f, height * 0.418f
            )
            cubicTo(
                width * 0.383f, height * 0.297f,
                width * 0.39f, height * 0.193f,
                width * 0.324f, height * 0.193f
            )
            close()
        }

        return Outline.Generic(path)
    }
}