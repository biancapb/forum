package br.com.alura.forum.mapper

interface MapperResposta <R, U> {

    fun map(r: R): U
}
