package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.Gray300
import co.edu.uniandes.vetcue.ui.theme.Gray400
import co.edu.uniandes.vetcue.ui.theme.Gray500
import co.edu.uniandes.vetcue.ui.theme.InterFamily
import co.edu.uniandes.vetcue.ui.theme.MontserratBold
import co.edu.uniandes.vetcue.ui.theme.MontserratFamily
import co.edu.uniandes.vetcue.ui.theme.Neutral300
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

@Composable
fun TemporizadorScreen(
    onCancelar: () -> Unit = {},
    onEjecutar: (minutos: Int) -> Unit = {}
) {
    var minutos by remember { mutableIntStateOf(5) }
    val dimens = rememberAppDimensions()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TemporizadorTitleSection()

        // Título "Temporizador"
        Text(
            text = "Temporizador",
            style = TextStyle(
                fontFamily = MontserratFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            ),
            color = Gray500,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(0.1f))

        // Número grande
        Text(
            text = "%02d".format(minutos),
            style = TextStyle(
                fontFamily = MontserratBold,
                fontWeight = FontWeight.Bold,
                fontSize = 120.sp,
                lineHeight = 120.sp
            ),
            color = Gray400,
            textAlign = TextAlign.Center
        )

        // "min"
        Text(
            text = "min",
            style = TextStyle(
                fontFamily = MontserratBold,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            ),
            color = Gray400,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(dimens.spacerXLarge))

        // Botones - y +
        Row(
            modifier = Modifier.width(dimens.buttonWidthCentered),
            horizontalArrangement = Arrangement.spacedBy(dimens.spacerLarge)
        ) {
            Button(
                onClick = { if (minutos > 1) minutos-- },
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight)
                    .border(1.dp, Neutral300, RoundedCornerShape(dimens.buttonCornerRadius)),
                shape = RoundedCornerShape(dimens.buttonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                )
            ) {
                Text(
                    text = "-",
                    style = TextStyle(
                        fontFamily = InterFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    ),
                    color = Gray300
                )
            }

            Button(
                onClick = { minutos++ },
                modifier = Modifier
                    .weight(1f)
                    .height(dimens.buttonHeight)
                    .border(1.dp, Neutral300, RoundedCornerShape(dimens.buttonCornerRadius)),
                shape = RoundedCornerShape(dimens.buttonCornerRadius),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                )
            ) {
                Text(
                    text = "+",
                    style = TextStyle(
                        fontFamily = InterFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    ),
                    color = Gray300
                )
            }
        }

        Spacer(modifier = Modifier.height(dimens.spacerXLarge))

        // Botones de acceso rápido 5 / 10 / 30 min
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimens.spacerLarge)
        ) {
            listOf(5, 10, 30).forEach { valor ->
                Button(
                    onClick = { minutos = valor },
                    modifier = Modifier
                        .weight(1f)
                        .height(dimens.buttonQuickHeight)
                        .border(1.dp, Neutral300, RoundedCornerShape(dimens.buttonCornerRadius)),
                    shape = RoundedCornerShape(dimens.buttonCornerRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = White,
                        contentColor = Black
                    )
                ) {
                    Text(
                        text = "$valor min",
                        style = MaterialTheme.typography.labelLarge,
                        color = Gray300
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(0.1f))

        // Botones CANCELAR / EJECUTAR
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
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Button(
                onClick = { onEjecutar(minutos) },
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
                    text = "EJECUTAR",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
private fun TemporizadorTitleSection() {
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
fun TemporizadorScreenPreview() {
    VetcueTheme {
        TemporizadorScreen()
    }
}
