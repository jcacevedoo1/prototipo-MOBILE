package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.InterFamily
import co.edu.uniandes.vetcue.ui.theme.MontserratBold
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.SecondaryNavyBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

@Composable
fun AlarmaScreen(
    hora: String = "9:30 am",
    onPosponer: () -> Unit = {},
    onEjecutar: () -> Unit = {}
) {
    val dimens = rememberAppDimensions()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlarmaTitleSection()

        Spacer(modifier = Modifier.weight(0.3f))

        // Campana
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Alarma",
            tint = PrimaryGreenBlack,
            modifier = Modifier.size(dimens.bellIconSize)
        )

        Spacer(modifier = Modifier.height(dimens.spacerMedium))

        // Hora
        Text(
            text = hora,
            fontFamily = MontserratBold,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = SecondaryNavyBlack,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimens.spacerXLarge))

        // Línea 1: Vaca 025 - Estrella - Lechera — Inter Regular 18
        Text(
            text = "Vaca 025 - Estrella - Lechera",
            fontFamily = InterFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimens.spacerLarge))

        // Línea 2: Antibiótico 5ml (Bold) IV (Regular)
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("Antibiótico 5ml ")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                    append("IV")
                }
            },
            color = Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimens.spacerLarge))

        // Línea 3: Corral (Regular) B (Bold) - Posición (Regular) 12 (Bold)
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                    append("Corral ")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("B")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                    append(" - Posición ")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("12")
                }
            },
            color = Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimens.spacerLarge))

        // Línea 4: Mastitis Aguda (Bold) - Día (Regular) 2 (Bold) /5 (Regular)
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("Mastitis Aguda")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                    append(" - Día ")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("2")
                }
                withStyle(SpanStyle(fontFamily = InterFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)) {
                    append("/5")
                }
            },
            color = Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botones
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimens.buttonBottomPadding),
            horizontalArrangement = Arrangement.spacedBy(dimens.spacerLarge)
        ) {
            Button(
                onClick = onPosponer,
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Danger100,
                    contentColor = White
                )
            ) {
                Text(
                    text = "POSPONER",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Button(
                onClick = onEjecutar,
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryGreen100,
                    contentColor = White,
                    disabledContainerColor = PrimaryGreen40,
                    disabledContentColor = Neutral500
                )
            ) {
                Text(
                    text = "EJECUTAR",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
private fun AlarmaTitleSection() {
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
fun AlarmaScreenPreview() {
    VetcueTheme {
        AlarmaScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlarmaScreen945Preview() {
    VetcueTheme {
        AlarmaScreen(hora = "9:45 AM")
    }
}
