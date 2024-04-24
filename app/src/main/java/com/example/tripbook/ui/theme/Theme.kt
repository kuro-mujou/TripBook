package com.example.tripbook.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    /*
        primary = primary_light,
        onPrimary = onPrimary_light,
        primaryContainer = primaryContainer_light,
        onPrimaryContainer = onPrimaryContainer_light,
        inversePrimary = inversePrimary_light,
        secondary = secondary_light,
        onSecondary = onSecondary_light,
        secondaryContainer = secondaryContainer_light,
        onSecondaryContainer = onSecondaryContainer_light,
        tertiary = tertiary_light,
        onTertiary = onTertiary_light,
        tertiaryContainer = tertiaryContainer_light,
        onTertiaryContainer = onTertiaryContainer_light,
        background = background_light,
        onBackground = onBackground_light,
        surface = surface_light,
        onSurface = onSurface_light,
        surfaceVariant = surfaceVariant_light,
        onSurfaceVariant = onSurfaceVariant_light,
        surfaceTint = surfaceTint_light,
        inverseSurface = inverseSurface_light,
        inverseOnSurface = inverseOnSurface_light,
        error = error_light,
        onError = onError_light,
        errorContainer = errorContainer_light,
        onErrorContainer = onErrorContainer_light,
        outline = outline_light,
        outlineVariant = outlineVariant_light,
        scrim = scrim,
        surfaceBright = surfaceBright_light,
        surfaceContainer = surfaceContainer_light,
        surfaceContainerHigh = surfaceContainerHigh_light,
        surfaceContainerHighest = surfaceContainerHighest_light,
        surfaceContainerLow = surfaceContainerLow_light,
        surfaceContainerLowest = surfaceContainerLowest_light,
        surfaceDim = surfaceDim_light
    * */
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    error = error_light,
)

private val LightColorScheme = lightColorScheme(
    /*
        primary = primary_dark,
        onPrimary = onPrimary_dark,
        primaryContainer = primaryContainer_dark,
        onPrimaryContainer = onPrimaryContainer_dark,
        inversePrimary = inversePrimary_dark,
        secondary = secondary_dark,
        onSecondary = onSecondary_dark,
        secondaryContainer = secondaryContainer_dark,
        onSecondaryContainer = onSecondaryContainer_dark,
        tertiary = tertiary_dark,
        onTertiary = onTertiary_dark,
        tertiaryContainer = tertiaryContainer_dark,
        onTertiaryContainer = onTertiaryContainer_dark,
        background = background_dark,
        onBackground = onBackground_dark,
        surface = surface_dark,
        onSurface = onSurface_dark,
        surfaceVariant = surfaceVariant_dark,
        onSurfaceVariant = onSurfaceVariant_dark,
        surfaceTint = surfaceTint_dark,
        inverseSurface = inverseSurface_dark,
        inverseOnSurface = inverseOnSurface_dark,
        error = error_dark,
        onError = onError_dark,
        errorContainer = errorContainer_dark,
        onErrorContainer = onErrorContainer_dark,
        outline = outline_dark,
        outlineVariant = outlineVariant_dark,
        scrim = scrim_dark,
        surfaceBright = surfaceBright_dark,
        surfaceContainer = surfaceContainer_dark,
        surfaceContainerHigh = surfaceContainerHigh_dark,
        surfaceContainerHighest = surfaceContainerHighest_dark,
        surfaceContainerLow = surfaceContainerLow_dark,
        surfaceContainerLowest = surfaceContainerLowest_dark,
        surfaceDim = surfaceDim_dark
    * */
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    error = error_dark
)

@Composable
fun TripBookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme)
                dynamicDarkColorScheme(context)
            else
                dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}