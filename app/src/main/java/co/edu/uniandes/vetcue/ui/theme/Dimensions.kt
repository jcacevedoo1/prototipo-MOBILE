package co.edu.uniandes.vetcue.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    // Layout general
    val screenWidth: Dp,
    val screenHeight: Dp,
    val horizontalPadding: Dp,      // ~6% ancho
    val headerTopSpacer: Dp,        // ~11% alto (el "Vetcue" al tope)
    val headerDividerThickness: Dp, // fija 4dp, no depende de pantalla
    val headerBottomSpacer: Dp,     // ~3% alto

    // Botones
    val buttonHeight: Dp,           // ~7% alto
    val buttonWidthCentered: Dp,    // ~50% ancho (botón FINALIZAR/DETENER)
    val buttonCornerRadius: Dp,     // fija 8dp
    val buttonBottomPadding: Dp,    // ~4% alto
    val buttonQuickHeight: Dp,      // ~5% alto (botones 5/10/30 min)

    // Íconos
    val bellIconSize: Dp,           // ~27% ancho
    val micCircleSize: Dp,          // ~60% ancho
    val micIconSize: Dp,            // ~47% ancho
    val cameraIconSize: Dp,         // ~12% ancho

    // Visor de cámara / foto
    val viewfinderHeight: Dp,       // ~38% alto

    // Temporizador
    val timerFontSizeDp: Dp,        // ~15% ancho (solo para referencia, fontSize en sp)
    val timerMinFontSizeDp: Dp,     // ~5% ancho

    // Espaciadores varios
    val spacerSmall: Dp,            // ~1% alto
    val spacerMedium: Dp,           // ~2% alto
    val spacerLarge: Dp,            // ~4% alto
    val spacerXLarge: Dp,           // ~8% alto
    val spacerBottom: Dp,           // ~4% alto
)

@Composable
fun rememberAppDimensions(): AppDimensions {
    val config = LocalConfiguration.current
    val w = config.screenWidthDp.dp
    val h = config.screenHeightDp.dp

    return AppDimensions(
        screenWidth = w,
        screenHeight = h,
        horizontalPadding = w * 0.06f,
        headerTopSpacer = h * 0.11f,
        headerDividerThickness = 4.dp,
        headerBottomSpacer = h * 0.03f,

        buttonHeight = h * 0.067f,
        buttonWidthCentered = w * 0.50f,
        buttonCornerRadius = 8.dp,
        buttonBottomPadding = h * 0.04f,
        buttonQuickHeight = h * 0.05f,

        bellIconSize = w * 0.54f,
        micCircleSize = w * 0.62f,
        micIconSize = w * 0.48f,
        cameraIconSize = w * 0.12f,

        viewfinderHeight = h * 0.38f,

        timerFontSizeDp = w * 0.30f,
        timerMinFontSizeDp = w * 0.10f,

        spacerSmall = h * 0.01f,
        spacerMedium = h * 0.02f,
        spacerLarge = h * 0.03f,
        spacerXLarge = h * 0.08f,
        spacerBottom = h * 0.04f,
    )
}

val LocalAppDimensions = compositionLocalOf<AppDimensions> {
    error("No AppDimensions provided")
}
