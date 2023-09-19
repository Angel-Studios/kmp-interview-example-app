package com.example.kmpInterview

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width

object AppStylesheet : StyleSheet() {
    init {
        for (element in listOf("table", "tr", "td")) {
            element style {
                border {
                    width = 1.px
                    style = LineStyle.Solid
                    color = Color("#000")
                }
            }
        }
    }

    val imgStyle by style {
        width(100.px)
        height(100.px)
    }
}