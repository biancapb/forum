package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.ErrorView
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest
import javax.websocket.server.PathParam

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper,
                    private val notFoundMessage: String = "Valor nao encontrado!") {

    fun listar(): List<TopicoView> /*lista os tópicos*/ {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
         }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topicos ->
            topicos.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }

        return topicoViewMapper.map(topico)

    }

    fun cadastrar(form: TopicoForm) : TopicoView /*DTO de entrada*/ {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) : TopicoView /*atualização*/ {
        val topico = topicos.stream().filter { topicos ->
            topicos.id == form.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }

        val topicoAtualizado = Topico(
                id = form.id,
                title = form.title,
                message = form.message,
                user = topico.user,
                course = topico.course,
                answer = topico.answer,
                status = topico.status,
                dateCreation = topico.dateCreation
        )
        //tudo que não for atualizado, recupera-se do topico, o que for modificado, vem do form
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { topicos ->
            topicos.id == id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }

        topicos = topicos.minus(topico)
    }
}