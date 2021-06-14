package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper) {

    fun listar(): List<TopicoView> /*lista os tópicos*/ {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
         }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topicos ->
            topicos.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)

    }

    fun cadastrar(form: TopicoForm) /*DTO de entrada*/ {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}