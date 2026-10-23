package franco.dahina.cartelera

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val inicio = if (Firebase.auth.currentUser != null) {
        "peliculas"
    } else {
        "login"
    }

    NavHost(
        navController = navController,
        startDestination = inicio,
        modifier = modifier
    ) {

        composable("login") {
            LoginScreen(
                onLoginOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onRegistrarse = {
                    navController.navigate("registro")
                }
            )
        }

        composable("registro") {
            RegistroScreen(
                onRegistroOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onCancelar = {
                    navController.popBackStack()
                }
            )
        }

        composable("peliculas") {
            PeliculasScreen(
                correo = Firebase.auth.currentUser?.email ?: "",
                onPeliculaClick = { id ->
                    navController.navigate("detalle/$id")
                },
                onCerrarSesion = {
                    Firebase.auth.signOut()

                    navController.navigate("login") {
                        popUpTo("peliculas") {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = "detalle/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { entrada ->

            val id = entrada.arguments?.getInt("id") ?: 1

            DetalleScreen(
                peliculaId = id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
