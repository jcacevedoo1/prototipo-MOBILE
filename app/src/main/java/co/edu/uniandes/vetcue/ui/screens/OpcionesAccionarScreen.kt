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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.edu.uniandes.vetcue.ui.theme.Black
import co.edu.uniandes.vetcue.ui.theme.Danger100
import co.edu.uniandes.vetcue.ui.theme.InterFamily
import co.edu.uniandes.vetcue.ui.theme.Neutral500
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen100
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen40
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreen80
import co.edu.uniandes.vetcue.ui.theme.PrimaryGreenBlack
import co.edu.uniandes.vetcue.ui.theme.VetcueTheme
import co.edu.uniandes.vetcue.ui.theme.White
import co.edu.uniandes.vetcue.ui.theme.rememberAppDimensions

@Composable
fun OpcionesAccionarScreen(
    onTemporizadorRapido: () -> Unit = {},
    onTomarFoto: () -> Unit = {},
    onNotaDeVoz: () -> Unit = {},
    onFinalizar: () -> Unit = {}
) {
    var mostrarModal by remember { mutableStateOf(false) }
    val dimens = rememberAppDimensions()

    Box(modifier = Modifier.fillMaxSize()) {

        // Pantalla principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(horizontal = dimens.horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OpcionesAccionarTitleSection()

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimens.spacerMedium)
            ) {
                Button(
                    onClick = onTemporizadorRapido,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimens.buttonHeight),
                    shape = RoundedCornerShape(dimens.buttonCornerRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryGreen80,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = "TEMPORIZADOR RÁPIDO",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = onTomarFoto,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimens.buttonHeight),
                    shape = RoundedCornerShape(dimens.buttonCornerRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryGreen80,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = "TOMAR FOTO",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = onNotaDeVoz,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimens.buttonHeight),
                    shape = RoundedCornerShape(dimens.buttonCornerRadius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryGreen80,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = "NOTA DE VOZ",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(dimens.spacerLarge))

            Button(
                onClick = { mostrarModal = true },
                modifier = Modifier
                    .width(dimens.buttonWidthCentered)
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
                    text = "FINALIZAR",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.height(dimens.spacerBottom))
        }

        // Scrim + modal
        if (mostrarModal) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.40f)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = dimens.horizontalPadding)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimens.spacerMedium)
                ) {
                    // Caja de texto
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White, RoundedCornerShape(dimens.buttonCornerRadius))
                            .border(1.dp, Black, RoundedCornerShape(dimens.buttonCornerRadius))
                            .padding(dimens.spacerLarge)
                    ) {
                        Text(
                            text = "Está a punto de terminar\nla acción de alerta\nasegúrese de haber guardado las\nevidencias necesarias.",
                            style = TextStyle(
                                fontFamily = InterFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            color = Black,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Botones fuera de la caja
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimens.spacerLarge)
                    ) {
                        Button(
                            onClick = { mostrarModal = false },
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
                            onClick = {
                                mostrarModal = false
                                onFinalizar()
                            },
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
                                text = "FINALIZAR",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OpcionesAccionarTitleSection() {
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
fun OpcionesAccionarScreenPreview() {
    VetcueTheme {
        OpcionesAccionarScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OpcionesAccionarScreenModalPreview() {
    VetcueTheme {
        // Muestra directamente el estado con modal abierto
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.8f))
                Text("Pantalla de fondo", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.weight(1f))
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.40f)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                            .border(1.dp, Black)
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Está a punto de terminar\nla acción de alerta\nasegúrese de haber guardado las\nevidencias necesarias.",
                            style = TextStyle(
                                fontFamily = InterFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            color = Black,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Danger100,
                                contentColor = White
                            )
                        ) {
                            Text("CANCELAR", style = MaterialTheme.typography.labelLarge)
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryGreen100,
                                contentColor = White
                            )
                        ) {
                            Text("FINALIZAR", style = MaterialTheme.typography.labelLarge)
                        }
                    }
                }
            }
        }
    }
}
