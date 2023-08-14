package com.example.handlingdiffrentscreensizes_jetpackcomposeway

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember


@Composable
fun ProvideDimenUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () ->Unit
) {
    val dimSet = remember{dimensions}
    val orientation = remember{orientation}
    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        LocalOrientationMode provides orientation,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf {
    mediumDimensions // Default Param
}

val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait // Default Param
}
