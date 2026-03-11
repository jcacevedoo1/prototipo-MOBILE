package co.edu.uniandes.vetcue.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val VetcueLightColorScheme = lightColorScheme(
    primary = PrimaryGreen100,
    onPrimary = White,
    primaryContainer = PrimaryGreen20,
    onPrimaryContainer = PrimaryGreenBlack,
    secondary = SecondaryNavy100,
    onSecondary = White,
    secondaryContainer = SecondaryNavy20,
    onSecondaryContainer = SecondaryNavyBlack,
    error = Danger100,
    onError = White,
    errorContainer = Danger40,
    onErrorContainer = DangerBlack,
    background = White,
    onBackground = Neutral900,
    surface = White,
    onSurface = Neutral900,
    surfaceVariant = Neutral100,
    onSurfaceVariant = Neutral700,
    outline = Neutral300,
)

@Composable
fun VetcueTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = VetcueLightColorScheme,
        typography = VetcueTypography,
        content = content
    )
}
