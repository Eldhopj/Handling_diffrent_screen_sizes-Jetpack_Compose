package com.example.handlingdiffrentscreensizes_jetpackcomposeway.ui.theme

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
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.Dimensions
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.LocalAppDimens
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.LocalOrientationMode
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.Orientation
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.ProvideDimenUtils
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.WindowDimension
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.WindowSize
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.compactDimensions
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.largeDimensions
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.mediumDimensions
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.smallDimensions
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.typographyBig
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.typographyCompact
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.typographyMedium
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.typographySmall

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun HandlingDiffrentScreenSizesJetpackComposeWayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    windowDimension: WindowDimension,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val orientation = when{
        windowDimension.width.size > windowDimension.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    val sizeThatMatters = when(orientation){
        Orientation.Portrait -> windowDimension.width
        else -> windowDimension.height
    }

    val dimensions = when(sizeThatMatters){
        is WindowSize.Small -> smallDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        else -> largeDimensions
    }

    val typography = when(sizeThatMatters){
        is WindowSize.Small -> typographySmall
        is WindowSize.Compact -> typographyCompact
        is WindowSize.Medium -> typographyMedium
        else -> typographyBig
    }

    ProvideDimenUtils(dimensions = dimensions, orientation = orientation) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

object AppTheme{
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val orientation:Orientation
        @Composable
        get() = LocalOrientationMode.current
}
