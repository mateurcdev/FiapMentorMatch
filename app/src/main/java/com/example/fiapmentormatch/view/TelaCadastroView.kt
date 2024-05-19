package com.example.fiapmentormatch.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fiapmentormatch.model.Aprendiz
import com.example.fiapmentormatch.model.Mentor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastroView() {
    var nome by remember { mutableStateOf(TextFieldValue("")) }
    var experiencia by remember { mutableStateOf(TextFieldValue("")) }
    var habilidades by remember { mutableStateOf(TextFieldValue("")) }
    var areasDeInteresse by remember { mutableStateOf(TextFieldValue("")) }
    var formacaoAcademica by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cadastro de Perfil", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Nome") },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
            )
        )

        OutlinedTextField(
            value = experiencia,
            onValueChange = { experiencia = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Experiência") },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
            )
        )

        OutlinedTextField(
            value = habilidades,
            onValueChange = { habilidades = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Habilidades (separadas por vírgula)") },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
            )
        )

        OutlinedTextField(
            value = areasDeInteresse,
            onValueChange = { areasDeInteresse = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Áreas de Interesse (separadas por vírgula)") },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
            )
        )

        OutlinedTextField(
            value = formacaoAcademica,
            onValueChange = { formacaoAcademica = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Formação Acadêmica") },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { salvarPerfil(nome.text, experiencia.text, habilidades.text, areasDeInteresse.text, formacaoAcademica.text, true) }) {
                Text("Salvar como Mentor")
            }
            Button(onClick = { salvarPerfil(nome.text, experiencia.text, habilidades.text, areasDeInteresse.text, formacaoAcademica.text, false) }) {
                Text("Salvar como Aprendiz")
            }
        }
    }
}

fun salvarPerfil(
    nome: String,
    experiencia: String,
    habilidades: String,
    areasDeInteresse: String,
    formacaoAcademica: String,
    isMentor: Boolean
) {
    val perfil = if (isMentor) {
        Mentor(
            nome,
            experiencia,
            habilidades.split(", "),
            areasDeInteresse.split(", "),
            formacaoAcademica
        )
    } else {
        Aprendiz(
            nome,
            experiencia,
            habilidades.split(", "),
            areasDeInteresse.split(", "),
            formacaoAcademica
        )
    }

    // TODO Aqui PRECISAMOS criar a chamada para a API/Func Salvar.
}
