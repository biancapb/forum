package br.com.alura.forum.mapper

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.TopicoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component
/*
@Component
class RespostaFormMapper (private val usuario: UsuarioService,
                          private val topico: TopicoService) : MapperResposta<RespostaForm, Resposta> {

    override fun map(r: RespostaForm): Resposta {
        return Resposta(
                        message = r.message,
                        user = usuario.buscarPorId(r.idUser),
                        topic = topico.buscarPorId(r.idTopic),
                        solution = true
                )

    }

}
*/