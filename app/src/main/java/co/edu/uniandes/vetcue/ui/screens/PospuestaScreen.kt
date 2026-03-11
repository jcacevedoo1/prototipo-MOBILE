package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Neutral300
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

@Composable
fun PospuestaScreen(
    onAlarmaPospuesta: () -> Unit = {}
) {
    val dimens = rememberAppDimensions()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PospuestaTitleSection()

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onAlarmaPospuesta,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.buttonHeight)
                .border(
                    width = 1.dp,
                    color = Neutral300,
                    shape = RoundedCornerShape(dimens.buttonCornerRadius)
                ),
            shape = RoundedCornerShape(dimens.buttonCornerRadius),
            colors = ButtonDefaults.buttonColors(
                containerColor = White,
                contentColor = Black
            )
        ) {
            Text(
                text = "ALARMA POSPUESTA",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun PospuestaTitleSection() {
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
fun PospuestaScreenPreview() {
    VetcueTheme {
        PospuestaScreen()
    }
}
