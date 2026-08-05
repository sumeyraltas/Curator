package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = WinePrimary,
    onPrimary = OnWinePrimary,
    primaryContainer = WinePrimaryContainer,
    onPrimaryContainer = OnWinePrimaryContainer,
    secondary = MutedText,
    onSecondary = Color.White,
    background = CreamBackground,
    onBackground = DarkText,
    surface = PureWhiteSurface,
    onSurface = DarkText,
    surfaceVariant = SurfaceContainerHigh,
    onSurfaceVariant = MutedText,
    outline = OutlineBorder,
    outlineVariant = GhostBorder
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFB2B8),
    onPrimary = Color(0xFF3C0610),
    primaryContainer = WinePrimaryContainer,
    onPrimaryContainer = Color(0xFFFFDADB),
    secondary = DarkTextSecondary,
    onSecondary = Color.Black,
    background = DarkBackground,
    onBackground = DarkTextPrimary,
    surface = DarkSurface,
    onSurface = DarkTextPrimary,
    surfaceVariant = Color(0xFF2B2627),
    onSurfaceVariant = DarkTextSecondary,
    outline = Color(0xFF534343),
    outlineVariant = Color(0xFF3D3334)
)

@Composable
fun CuratorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep gallery branded colors primary
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
