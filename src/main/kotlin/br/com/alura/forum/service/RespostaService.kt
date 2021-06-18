package br.com.alura.forum.service

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.dto.TopicoView
//import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.mapper.RespostaViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
/*
@Service
class RespostaService(private var respostas: List<Resposta>,
                      private val respostaFormMapper: RespostaFormMapper,
                      private val respostaViewMapper: RespostaViewMapper) {

//    init {
//        val primeiraResposta = Resposta(
//            id = 1,
//            message = "Você pode utilizar o List<> ou o ArrayList",
//            user = Usuario(
//                id = 1,
//                name = "Bianca",
//                email = "bpbarbosa.developer@gmail.com"
//            ),
//            topic = Topico(
//                id = 1,
//                title = "Duvidas sobre Kotlin",
//                message = "Como criar uma lista utilizando Kotlin?",
//                course = Curso(
//                    id = 1,
//                    name = "Kotlin",
//                    category = "Programação"
//                ),
//                user = Usuario(
//                    id = 1,
//                    name = "Bianca",
//                    email = "bpbarbosa.developer@gmail.com"
//                )
//            ),
//            solution = false
//        )
//        respostas = Arrays.asList(primeiraResposta)
//    }
/*
    fun respostas(idTopico: Long): List<Resposta> {
        return respostas.stream().filter { r ->
            r.topic.id == idTopico
        }.collect(Collectors.toList())
    }


    fun buscarPorId(id: Long): RespostaView {
        val resposta = respostas.stream().filter { topicos ->
            topicos.id == id
        }.findFirst().get()

        return respostaViewMapper.map(resposta)

    }


    fun cadastrar(form: RespostaForm, idTopico: Long) {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topic = respostas.buscarPorId(buscarPorId(idTopico))/*.buscarPorId(idTopico)*/

        respostas = respostas.plus(resposta)
    }*/
}*/