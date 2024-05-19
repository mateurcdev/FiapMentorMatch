package com.example.fiapmentormatch.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fiapmentormatch.model.Aprendiz
import com.example.fiapmentormatch.model.Mentor

@Composable
fun TelaCadastroView(onNavigateBack: () -> Unit, onNavigateToMenu: () -> Unit) {
    val context = LocalContext.current
    var nome by remember { mutableStateOf(TextFieldValue("")) }
    var experiencia by remember { mutableStateOf(TextFieldValue("")) }
    var habilidades by remember { mutableStateOf(TextFieldValue("")) }
    var areasDeInteresse by remember { mutableStateOf(TextFieldValue("")) }
    var formacaoAcademica by remember { mutableStateOf(TextFieldValue("")) }
    var user by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var localization by remember { mutableStateOf(TextFieldValue("")) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var isMentor by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Text("Cadastro de Perfil", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

                OutlinedTextField(
                    value = user,
                    onValueChange = { user = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Usuário") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = localization,
                    onValueChange = { localization = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Localização") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Nome") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = experiencia,
                    onValueChange = { experiencia = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Experiência") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = habilidades,
                    onValueChange = { habilidades = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Habilidades (separadas por vírgula)") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = areasDeInteresse,
                    onValueChange = { areasDeInteresse = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Áreas de Interesse (separadas por vírgula)") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                OutlinedTextField(
                    value = formacaoAcademica,
                    onValueChange = { formacaoAcademica = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = { Text("Formação Acadêmica") },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        isMentor = true
                        salvarPerfil(context, nome.text, experiencia.text, habilidades.text, areasDeInteresse.text, formacaoAcademica.text, user.text, password.text, localization.text, true) { message ->
                            dialogMessage = message
                            showDialog = true
                        }
                    }) {
                        Text("Salvar como Mentor")
                    }
                    Button(onClick = {
                        isMentor = false
                        salvarPerfil(context, nome.text, experiencia.text, habilidades.text, areasDeInteresse.text, formacaoAcademica.text, user.text, password.text, localization.text, false) { message ->
                            dialogMessage = message
                            showDialog = true
                        }
                    }) {
                        Text("Salvar como Aprendiz")
                    }
                }

                TextButton(onClick = onNavigateBack) {
                    Text("Voltar para Login")
                }
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = if (isMentor) "Mentor" else "Aprendiz") },
                text = { Text(text = if (isMentor) "Perfil de mentor salvo com sucesso!" else "Perfil de aprendiz salvo com sucesso!") },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            onNavigateToMenu()
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

fun salvarPerfil(
    context: android.content.Context,
    nome: String,
    experiencia: String,
    habilidades: String,
    areasDeInteresse: String,
    formacaoAcademica: String,
    user: String,
    password: String,
    localization: String,
    isMentor: Boolean,
    onResult: (String) -> Unit
) {
    val perfil = if (isMentor) {
        Mentor(nome, experiencia, habilidades.split(", "), areasDeInteresse.split(", "), formacaoAcademica, user, password, localization)
    } else {
        Aprendiz(nome, experiencia, habilidades.split(", "), areasDeInteresse.split(", "), formacaoAcademica, user, password, localization)
    }

    // Simulação de salvamento e retorno
    onResult("Perfil salvo com sucesso!")
}
