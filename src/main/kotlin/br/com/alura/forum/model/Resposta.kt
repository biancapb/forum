package br.com.alura.forum.model

import br.com.alura.forum.dto.TopicoView
import java.time.LocalDateTime

data class Resposta(
        var id: Long? = null,
        val message: String,
        val dateCreation: LocalDateTime = LocalDateTime.now(),
        val user: Usuario,
        var topic: Topico /*Topico*/,
        val solution: Boolean
)
