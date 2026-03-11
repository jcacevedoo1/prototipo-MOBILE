package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.Gray400
import co.edu.uniandes.vetcue.ui.theme.MontserratBold
import co.edu.uniandes.vetcue.ui.theme.MontserratFamily
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions
import kotlinx.coroutines.delay

@Composable
fun TemporizadorActivoScreen(
    minutosIniciales: Int = 5,
    onDetener: () -> Unit = {},
    onTiempoFinalizado: () -> Unit = {}
) {
    var segundosRestantes by remember { mutableIntStateOf(minutosIniciales * 60) }

    // Cuenta regresiva: descuenta 1 segundo cada segundo
    LaunchedEffect(minutosIniciales) {
        while (segundosRestantes > 0) {
            delay(1000L)
            segundosRestantes--
        }
        onTiempoFinalizado()
    }

    val minutos = segundosRestantes / 60
    val segundos = segundosRestantes % 60
    val tiempoFormateado = "%02d:%02d".format(minutos, segundos)
    val dimens = rememberAppDimensions()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onTiempoFinalizado() }
    ) {
        Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemporizadorActivoTitleSection()

            // Título "Temporizador"
            Text(
                text = "Temporizador",
                style = TextStyle(
                    fontFamily = MontserratFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                ),
                color = Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(0.3f))

            // Tiempo restante
            Text(
                text = tiempoFormateado,
                style = TextStyle(
                    fontFamily = MontserratBold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 80.sp,
                    lineHeight = 80.sp
                ),
                color = Gray400,
                textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.height(dimens.spacerXLarge))

        // Botón DETENER
        Button(
            onClick = onDetener,
            modifier = Modifier
                .width(dimens.buttonWidthCentered)
                .height(dimens.buttonHeight),
            shape = RoundedCornerShape(dimens.buttonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Danger100,
                    contentColor = White
                )
            ) {
                Text(
                    text = "DETENER",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(dimens.spacerBottom))
        }
    }
}

@Composable
private fun TemporizadorActivoTitleSection() {
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
fun TemporizadorActivoScreenPreview() {
    VetcueTheme {
        TemporizadorActivoScreen(minutosIniciales = 5)
    }
}
