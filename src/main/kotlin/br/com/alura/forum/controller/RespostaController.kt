package br.com.alura.forum.controller

import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping("/{id}")
    fun respostas(@PathVariable id: Long): List<Resposta> {
        return service.respostas(id)
    }

}