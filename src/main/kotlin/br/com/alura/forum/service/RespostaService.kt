package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>) {

    init {
        val primeiraResposta = Resposta(
            id = 1,
            message = "Você pode utilizar o List<> ou o ArrayList",
            user = Usuario(
                id = 1,
                name = "Bianca",
                email = "bpbarbosa.developer@gmail.com"
            ),
            topic = Topico(
                id = 1,
                title = "Duvidas sobre Kotlin",
                message = "Como criar uma lista utilizando Kotlin?",
                course = Curso(
                    id = 1,
                    name = "Kotlin",
                    category = "Programação"
                ),
                user = Usuario(
                    id = 1,
                    name = "Bianca",
                    email = "bpbarbosa.developer@gmail.com"
                )
            ),
            solution = false
        )
        respostas = Arrays.asList(primeiraResposta)
    }

    fun respostas(idTopico: Long): List<Resposta> {
        return respostas.stream().filter { r ->
            r.topic.id == idTopico
        }.collect(Collectors.toList())
    }
}