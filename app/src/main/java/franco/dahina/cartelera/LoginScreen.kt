package franco.dahina.cartelera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import franco.dahina.cartelera.ui.theme.CarteleraTheme

@Composable
fun LoginScreen(
    onLoginOk: () -> Unit,
    onRegistrarse: () -> Unit
) {
    var correo by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var hayError by rememberSaveable { mutableStateOf(false) }
    var cargando by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Cartelera",
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                hayError = false
            },
            label = { Text("Correo electrónico") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            isError = hayError,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = contrasena,
            onValueChange = {
                contrasena = it
                hayError = false
            },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            isError = hayError,
            modifier = Modifier.fillMaxWidth()
        )

        if (hayError) {
            Text(
                text = "Correo o contraseña incorrectos",
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                if (correo.isBlank() || contrasena.isBlank()) {
                    hayError = true
                } else {
                    cargando = true
                    hayError = false

                    Firebase.auth
                        .signInWithEmailAndPassword(
                            correo.trim(),
                            contrasena
                        )
                        .addOnCompleteListener { tarea ->
                            cargando = false

                            if (tarea.isSuccessful) {
                                onLoginOk()
                            } else {
                                hayError = true
                            }
                        }
                }
            },
            enabled = !cargando,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (cargando) "Ingresando..."
                else "Ingresar"
            )
        }

        TextButton(
            onClick = onRegistrarse,
            enabled = !cargando
        ) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    CarteleraTheme {
        LoginScreen(
            onLoginOk = {},
            onRegistrarse = {}
        )
    }
}
