package br.com.alura.forum.dto

data class TopicoForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idUser: Long
    )
