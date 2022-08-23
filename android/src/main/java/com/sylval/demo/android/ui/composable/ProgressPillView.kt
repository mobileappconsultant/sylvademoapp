package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.theme.PrimaryColor

@Composable
fun ProgressStepView(modifier: Modifier, currentLevel: Int, totalSteps: Int) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..totalSteps) {
            val stepType = when {
                i < currentLevel -> {
                    StepType.Seen
                }
                i == currentLevel -> {
                    StepType.Selected
                }
                else -> {
                    StepType.UnSeen
                }
            }
            Step(stepType)
            if (i < totalSteps) {
                Row(modifier = Modifier.weight(1f)) {
                    Divider(
                        Modifier
                            .height(2.dp)
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth(),
                        color = PrimaryColor
                    )
                }
            }
        }
    }
}

@Composable
fun Step(stepType: StepType) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .border(width = 1.dp, stepType.borderColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .padding(all = 4.dp)
                    .background(shape = CircleShape, color = stepType.color)
            )
        }
    }
}

enum class StepType(val color: Color, val borderColor: Color) {
    Selected(PrimaryColor, PrimaryColor),
    Seen(PrimaryColor, Transparent),
    UnSeen(Transparent, PrimaryColor)
}

@Preview
@Composable
fun PreviewStep() {
    Box(modifier = Modifier.background(Color.White)) {
        ProgressStepView(modifier = Modifier.padding(horizontal = 32.dp), 3, 5)
    }
}
