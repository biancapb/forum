package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val curso: CursoService,
                    private val usuario: UsuarioService
                    ) {

    fun listar(): List<TopicoView> /*lista os tópicos*/ {
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            title = t.title,
            message = t.message,
            date = t.dateCreation,
            status = t.status
        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topicos ->
            topicos.id == id
        }.findFirst().get()

        return TopicoView(
            id = topico.id,
            title = topico.title,
            message = topico.message,
            date = topico.dateCreation,
            status = topico.status
        )
    }

    fun cadastrar(form: TopicoForm) /*DTO de entrada*/ {
        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                title = form.title,
                message = form.message,
                course = curso.buscarPorId(form.idCourse),
                user = usuario.buscarPorId(form.idUser)
        ))
    }
}