package com.example.gradienttext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.InternalFoundationTextApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.horizontalGradient
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienttext.ui.theme.GradientTextTheme

class MainActivity : ComponentActivity() {
    @InternalFoundationTextApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GradientText(
                        "Android",
                        brush = horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colors.primary,
                                MaterialTheme.colors.secondary,
                            )
                        )
                    )
                }
            }
        }
    }
}

@InternalFoundationTextApi
@Preview
@Composable
fun GradientTextWithoutSurfacePreview() {
    GradientTextTheme {
        GradientText(
            "Android",
            Brush.horizontalGradient(
                colors = listOf(
                    MaterialTheme.colors.primary,
                    MaterialTheme.colors.secondary,
                )
            )
        )
    }
}

@InternalFoundationTextApi
@Preview
@Composable
fun GradientTextWithSurfacePreview() {
    GradientTextTheme {
        Surface {
            GradientText(
                "Android",
                Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.secondary,
                    )
                )
            )
        }
    }
}