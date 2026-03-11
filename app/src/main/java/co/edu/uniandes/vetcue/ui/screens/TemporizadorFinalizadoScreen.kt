package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Gray400
import co.edu.uniandes.vetcue.ui.theme.MontserratBold
import co.edu.uniandes.vetcue.ui.theme.MontserratFamily
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

@Composable
fun TemporizadorFinalizadoScreen(
    onCompletado: () -> Unit = {}
) {
    val dimens = rememberAppDimensions()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TemporizadorFinalizadoTitleSection()

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

        Text(
            text = "00:00",
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

        Button(
            onClick = onCompletado,
            modifier = Modifier
                .fillMaxWidth(0.5f)
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
                text = "COMPLETADO",
                style = MaterialTheme.typography.labelLarge
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(dimens.spacerBottom))
    }
}

@Composable
private fun TemporizadorFinalizadoTitleSection() {
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
fun TemporizadorFinalizadoScreenPreview() {
    VetcueTheme {
        TemporizadorFinalizadoScreen()
    }
}
