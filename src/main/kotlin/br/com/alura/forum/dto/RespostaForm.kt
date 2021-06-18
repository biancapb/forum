package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RespostaForm(
     @field:NotEmpty
     val message: String,
     @field:NotNull
     val idUser: Long,
     @field:NotNull
     val idTopic: Long
)