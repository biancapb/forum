package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
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
        )

        val segundoTopico = Topico(
            id = 2,
            title = "Como instanciar classe em Java?",
            message = "Eu estou com dúvidas sobre instanciamento de classes na linguagem Java",
            course = Curso(
                id = 2,
                name = "Java",
                category = "Programação"
            ),
            user = Usuario(
                id = 2,
                name = "Luana",
                email = "luana.gonzales@gmail.com"
            )
        )

        val terceiroTopico = Topico(
            id = 3,
            title = "Qual a diferença de UX e UI Design?",
            message = "Estava querendo saber qual a diferença??",
            course = Curso(
                id = 3,
                name = "Introdução a UX/UI Design",
                category = "UX/UI Design"
            ),
            user = Usuario(
                id = 3,
                name = "Nathan",
                email = "nathan@hotmail.com"
            )
        )

        topicos = Arrays.asList(topico, segundoTopico, terceiroTopico)

    }

    fun listar(): List<Topico> /*lista os tópicos*/ {
        return topicos
    }

    fun listarPorId(id: Long): Topico {
        return topicos.stream().filter ({
            topicos -> topicos.id == id
        }).findFirst().get()
    }
}