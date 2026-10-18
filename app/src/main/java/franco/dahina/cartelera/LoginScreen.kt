package franco.dahina.cartelera

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import franco.dahina.cartelera.ui.theme.CarteleraTheme

@Composable
fun LoginScreen(onLoginOk: () -> Unit) {

    var usuario by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var hayError by rememberSaveable { mutableStateOf(false) }

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
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            singleLine = true,
            isError = hayError,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
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
                text = "Usuario o contraseña incorrectos",
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                if (usuario.trim() == "admin" &&
                    contrasena == "admin"
                ) {
                    onLoginOk()
                } else {
                    hayError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    CarteleraTheme {
        LoginScreen(onLoginOk = { })
    }
}
