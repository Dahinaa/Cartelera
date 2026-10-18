package franco.dahina.cartelera

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginScreen(
                onLoginOk = {
                    navController.navigate("peliculas") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("peliculas") {
            PeliculasScreen(
                onPeliculaClick = { id ->
                    navController.navigate("detalle/$id")
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
