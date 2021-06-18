package br.com.alura.forum.dto

import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import java.time.LocalDateTime

class RespostaView (
        var id: Long? = null,
        val message: String,
        val user: Usuario,
        val topic: Topico,
        val solution: Boolean
)