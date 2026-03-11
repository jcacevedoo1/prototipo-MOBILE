package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

private val WaveformColor = Color(0xFF868585)

private val waveformHeights = listOf(
    0.15f, 0.35f, 0.60f, 0.85f,
    1.00f,
    0.85f, 0.60f, 0.35f, 0.15f
)

@Composable
fun GrabarNotaScreen(
    onCancelar: () -> Unit = {},
    onGuardar: () -> Unit = {}
) {
    val dimens = rememberAppDimensions()
    val waveformSize = dimens.screenWidth * 0.42f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GrabarNotaTitleSection()

        Spacer(modifier = Modifier.weight(0.4f))

        // Botón circular de micrófono
        Box(
            modifier = Modifier
                .size(dimens.micCircleSize)
                .clip(CircleShape)
                .background(WaveformColor.copy(alpha = 0.20f))
                .border(
                    width = 1.dp,
                    color = WaveformColor.copy(alpha = 0.40f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Mic,
                contentDescription = "Grabar nota de voz",
                tint = PrimaryGreenBlack,
                modifier = Modifier.size(dimens.micIconSize)
            )
        }

        Spacer(modifier = Modifier.height(dimens.spacerXLarge))

        // Visualización de onda de audio
        AudioWaveform(
            totalSize = waveformSize,
            barColor = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botones CANCELAR y GUARDAR
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimens.buttonBottomPadding),
            horizontalArrangement = Arrangement.spacedBy(dimens.spacerLarge)
        ) {
            Button(
                onClick = onCancelar,
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight),
                shape = RoundedCornerShape(dimens.buttonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Danger100,
                    contentColor = White
                )
            ) {
                Text(
                    text = "CANCELAR",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = onGuardar,
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight),
                shape = RoundedCornerShape(dimens.buttonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryGreen100,
                    contentColor = White,
                    disabledContainerColor = PrimaryGreen40,
                    disabledContentColor = Neutral500
                )
            ) {
                Text(
                    text = "GUARDAR",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun AudioWaveform(totalSize: Dp, barColor: Color) {
    val barWidth = totalSize * 0.047f
    val barSpacing = totalSize * 0.059f

    Row(
        modifier = Modifier.size(totalSize),
        horizontalArrangement = Arrangement.spacedBy(barSpacing, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        waveformHeights.forEach { heightFraction ->
            Box(
                modifier = Modifier
                    .width(barWidth)
                    .height(totalSize * heightFraction)
                    .clip(RoundedCornerShape(3.dp))
                    .background(barColor)
            )
        }
    }
}

@Composable
private fun GrabarNotaTitleSection() {
    val dimens = rememberAppDimensions()
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(dimens.headerTopSpacer))
        Text(
            text = "Vetcue",
            style = MaterialTheme.typography.headlineLarge,
            color = PrimaryGreenBlack,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dimens.spacerMedium))
        HorizontalDivider(
            color = PrimaryGreen80.copy(alpha = 0.2f),
            thickness = dimens.headerDividerThickness,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dimens.headerBottomSpacer))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GrabarNotaScreenPreview() {
    VetcueTheme {
        GrabarNotaScreen()
    }
}
