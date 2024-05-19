package com.example.fiapmentormatch.model

open class Perfil(
    val nome: String,
    val experiencia: String,
    val habilidades: List<String>,
    val areasDeInteresse: List<String>,
    val formacaoAcademica: String
) {
    override fun toString(): String = "Nome: $nome\n" +
            "Experiência: $experiencia\n" +
            "Habilidades: ${habilidades.joinToString(", ")}\n" +
            "Áreas de Interesse: ${areasDeInteresse.joinToString(", ")}\n" +
            "Formação Acadêmica: $formacaoAcademica"
}