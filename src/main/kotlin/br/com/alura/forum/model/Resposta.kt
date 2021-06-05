package br.com.alura.forum.model

import java.time.LocalDateTime

data class Resposta(
    val id: Long?,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val user: Usuario,
    val topic: Topico,
    val solution: Boolean
)
