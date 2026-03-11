package co.edu.uniandes.vetcue.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.uniandes.vetcue.R
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

private val ViewfinderBorder = Color(0xFF868585)

@Composable
fun GuardarFotoScreen(
    onCancelar: () -> Unit = {},
    onGuardarFoto: () -> Unit = {}
) {
    val dimens = rememberAppDimensions()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = dimens.horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GuardarFotoTitleSection()

        // Foto tomada
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.viewfinderHeight)
                .border(
                    width = 1.dp,
                    color = ViewfinderBorder.copy(alpha = 0.40f),
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto_campo),
                contentDescription = "Foto tomada",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botones CANCELAR y GUARDAR FOTO
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
                onClick = onGuardarFoto,
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
                    text = "GUARDAR FOTO",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun GuardarFotoTitleSection() {
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
fun GuardarFotoScreenPreview() {
    VetcueTheme {
        GuardarFotoScreen()
    }
}
