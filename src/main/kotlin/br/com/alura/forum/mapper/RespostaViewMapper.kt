package br.com.alura.forum.mapper

import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper : MapperResposta<Resposta, RespostaView> {
    override fun map(r: Resposta): RespostaView {
        return RespostaView(
                id = r.id,
                message = r.message,
                user = r.user,
                topic = r.topic,
                solution = r.solution
        )
    }

}