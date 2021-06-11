package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topico(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(), /*pega a data atual*/
    val course: Curso,
    val user: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val answer: List<Resposta> = ArrayList()
)