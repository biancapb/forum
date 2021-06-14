package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
        private val curso: CursoService,
        private val usuario: UsuarioService
) : Mapper<TopicoForm, Topico>{
    override fun map(t: TopicoForm): Topico {
        return Topico(
                title = t.title,
                message = t.message,
                course = curso.buscarPorId(t.idCourse),
                user = usuario.buscarPorId(t.idUser)
        )
    }

}
