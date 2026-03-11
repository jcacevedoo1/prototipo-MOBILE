package co.edu.uniandes.vetcue.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.edu.uniandes.vetcue.ui.screens.AlarmaScreen
import co.edu.uniandes.vetcue.ui.screens.GrabarNotaScreen
import co.edu.uniandes.vetcue.ui.screens.GuardarFotoScreen
import co.edu.uniandes.vetcue.ui.screens.LoginScreen
import co.edu.uniandes.vetcue.ui.screens.OpcionesAccionarScreen
import co.edu.uniandes.vetcue.ui.screens.PospuestaScreen
import co.edu.uniandes.vetcue.ui.screens.PosponerScreen
import co.edu.uniandes.vetcue.ui.screens.TemporizadorActivoScreen
import co.edu.uniandes.vetcue.ui.screens.TemporizadorFinalizadoScreen
import co.edu.uniandes.vetcue.ui.screens.TemporizadorScreen
import co.edu.uniandes.vetcue.ui.screens.TomarFotoScreen

object Routes {
    const val LOGIN = "login"
    const val ALARMA_930 = "alarma_930"
    const val ALARMA_945 = "alarma_945"
    const val POSPONER = "posponer"
    const val POSPUESTA = "pospuesta"
    const val OPCIONES_ACCIONAR = "opciones_accionar"
    const val TEMPORIZADOR = "temporizador"
    const val TEMPORIZADOR_ACTIVO = "temporizador_activo/{minutos}"
    fun temporizadorActivo(minutos: Int) = "temporizador_activo/$minutos"
    const val TEMPORIZADOR_FINALIZADO = "temporizador_finalizado"
    const val TOMAR_FOTO = "tomar_foto"
    const val GUARDAR_FOTO = "guardar_foto"
    const val GRABAR_NOTA = "grabar_nota"
}

@Composable
fun VetcueNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        // ── Login ──────────────────────────────────────────────────────────────
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.ALARMA_930) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        // ── Alarma 9:30 ────────────────────────────────────────────────────────
        composable(Routes.ALARMA_930) {
            AlarmaScreen(
                hora = "9:30 am",
                onPosponer = { navController.navigate(Routes.POSPONER) },
                onEjecutar = { navController.navigate(Routes.OPCIONES_ACCIONAR) }
            )
        }

        // ── Posponer ───────────────────────────────────────────────────────────
        composable(Routes.POSPONER) {
            PosponerScreen(
                onPosponer15Min = {
                    navController.navigate(Routes.POSPUESTA) {
                        popUpTo(Routes.ALARMA_930) { inclusive = false }
                    }
                },
                onPosponerSiguienteAnimal = {
                    navController.navigate(Routes.POSPUESTA) {
                        popUpTo(Routes.ALARMA_930) { inclusive = false }
                    }
                }
            )
        }

        // ── Pospuesta ──────────────────────────────────────────────────────────
        composable(Routes.POSPUESTA) {
            PospuestaScreen(
                onAlarmaPospuesta = {
                    navController.navigate(Routes.ALARMA_945) {
                        popUpTo(Routes.ALARMA_930) { inclusive = true }
                    }
                }
            )
        }

        // ── Alarma 9:45 ────────────────────────────────────────────────────────
        composable(Routes.ALARMA_945) {
            AlarmaScreen(
                hora = "9:45 AM",
                onPosponer = { navController.navigate(Routes.POSPONER) },
                onEjecutar = { navController.navigate(Routes.OPCIONES_ACCIONAR) }
            )
        }

        // ── Opciones Accionar ──────────────────────────────────────────────────
        composable(Routes.OPCIONES_ACCIONAR) {
            OpcionesAccionarScreen(
                onTemporizadorRapido = { navController.navigate(Routes.TEMPORIZADOR) },
                onTomarFoto = { navController.navigate(Routes.TOMAR_FOTO) },
                onNotaDeVoz = { navController.navigate(Routes.GRABAR_NOTA) },
                onFinalizar = { (context as? Activity)?.finish() }
            )
        }

        // ── Temporizador (configuración) ───────────────────────────────────────
        composable(Routes.TEMPORIZADOR) {
            TemporizadorScreen(
                onCancelar = { navController.popBackStack() },
                onEjecutar = { minutos ->
                    navController.navigate(Routes.temporizadorActivo(minutos)) {
                        popUpTo(Routes.TEMPORIZADOR) { inclusive = true }
                    }
                }
            )
        }

        // ── Temporizador activo ────────────────────────────────────────────────
        composable(
            route = Routes.TEMPORIZADOR_ACTIVO,
            arguments = listOf(navArgument("minutos") { type = NavType.IntType })
        ) { backStackEntry ->
            val minutos = backStackEntry.arguments?.getInt("minutos") ?: 5
            TemporizadorActivoScreen(
                minutosIniciales = minutos,
                onDetener = {
                    navController.navigate(Routes.OPCIONES_ACCIONAR) {
                        popUpTo(Routes.OPCIONES_ACCIONAR) { inclusive = true }
                    }
                },
                onTiempoFinalizado = {
                    navController.navigate(Routes.TEMPORIZADOR_FINALIZADO) {
                        popUpTo(Routes.TEMPORIZADOR_ACTIVO) { inclusive = true }
                    }
                }
            )
        }

        // ── Temporizador finalizado ────────────────────────────────────────────
        composable(Routes.TEMPORIZADOR_FINALIZADO) {
            TemporizadorFinalizadoScreen(
                onCompletado = {
                    navController.navigate(Routes.OPCIONES_ACCIONAR) {
                        popUpTo(Routes.OPCIONES_ACCIONAR) { inclusive = true }
                    }
                }
            )
        }

        // ── Tomar foto ─────────────────────────────────────────────────────────
        composable(Routes.TOMAR_FOTO) {
            TomarFotoScreen(
                onCancelar = { navController.popBackStack() },
                onTomarFoto = {
                    navController.navigate(Routes.GUARDAR_FOTO) {
                        popUpTo(Routes.TOMAR_FOTO) { inclusive = true }
                    }
                }
            )
        }

        // ── Guardar foto ───────────────────────────────────────────────────────
        composable(Routes.GUARDAR_FOTO) {
            GuardarFotoScreen(
                onCancelar = {
                    navController.navigate(Routes.OPCIONES_ACCIONAR) {
                        popUpTo(Routes.OPCIONES_ACCIONAR) { inclusive = true }
                    }
                },
                onGuardarFoto = {
                    navController.navigate(Routes.OPCIONES_ACCIONAR) {
                        popUpTo(Routes.OPCIONES_ACCIONAR) { inclusive = true }
                    }
                }
            )
        }

        // ── Grabar nota de voz ─────────────────────────────────────────────────
        composable(Routes.GRABAR_NOTA) {
            GrabarNotaScreen(
                onCancelar = { navController.popBackStack() },
                onGuardar = { navController.popBackStack() }
            )
        }
    }
}
