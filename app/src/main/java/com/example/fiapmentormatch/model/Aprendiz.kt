package com.example.fiapmentormatch.model

class Aprendiz(
    nome: String,
    experiencia: String,
    habilidades: List<String>,
    areasDeInteresse: List<String>,
    formacaoAcademica: String,
    usuario: String,
    senha: String,
    localizacao: String
) : Perfil(nome, experiencia, habilidades, areasDeInteresse, formacaoAcademica)
