package com.liecoti.app.ui.intro

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liecoti.app.localization.Localization
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun IntroScreen(onStart: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "gradient")

    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "gradientOffset"
    )

    val color1 = Color(0xFF3D2B7A)
    val color2 = Color(0xFF1E88E5)
    val color3 = Color(0xFFE040FB)
    val color4 = Color(0xFF00BCD4)

    val gradientColors = listOf(
        Color.Lerp(color1, color2, animatedOffset),
        Color.Lerp(color2, color3, animatedOffset),
        Color.Lerp(color3, color4, animatedOffset),
        Color.Lerp(color4, color1, animatedOffset)
    )

    val logoAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(
            durationMillis = 1400,
            delayMillis = 60,
            easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)
        ),
        label = "logoAlpha"
    )

    val logoTranslationY by animateFloatAsState(
        targetValue = 0f,
        animationSpec = tween(
            durationMillis = 1700,
            easing = CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f)
        ),
        label = "logoTranslationY"
    )

    val logoScale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "logoScale"
    )

    var buttonVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(1200)
        buttonVisible = true
    }

    val buttonAlpha by animateFloatAsState(
        targetValue = if (buttonVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 500, easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)),
        label = "buttonAlpha"
    )

    val buttonScale by animateFloatAsState(
        targetValue = if (buttonVisible) 1f else 0.9f,
        animationSpec = tween(
            durationMillis = 600,
            delayMillis = 0,
            easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)
        ),
        label = "buttonScale"
    )

    val strings = Localization.current()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(size.width * animatedOffset, 0f),
                    end = Offset(size.width * (1f - animatedOffset), size.height)
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = strings.welcomeTitle,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = logoAlpha
                        translationY = logoTranslationY
                        scaleX = logoScale
                        scaleY = logoScale
                    }
                    .padding(bottom = 16.dp)
            )

            Text(
                text = strings.welcomeSubtitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = logoAlpha
                        translationY = logoTranslationY * 0.5f
                    }
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 64.dp)
            )

            Button(
                onClick = onStart,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = buttonAlpha
                        scaleX = buttonScale
                        scaleY = buttonScale
                    }
                    .width(200.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColorsPrimary()
            ) {
                Text(
                    text = strings.start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

private fun Color.Lerp(other: Color, fraction: Float): Color {
    return Color(
        red = this.red + (other.red - this.red) * fraction,
        green = this.green + (other.green - this.green) * fraction,
        blue = this.blue + (other.blue - this.blue) * fraction,
        alpha = 1f
    )
}
