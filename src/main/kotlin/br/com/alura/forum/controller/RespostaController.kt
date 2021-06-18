package br.com.alura.forum.controller

import br.com.alura.forum.dto.RespostaForm
import br.com.alura.forum.model.Resposta
//import br.com.alura.forum.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
/*
@RestController
@RequestMapping("/topicos/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping("/{id}")
    fun respostas(@PathVariable id: Long): List<Resposta> {
        return service.respostas(id)
    }

    @PostMapping
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid form: RespostaForm) {
        service.cadastrar(form, id)
    }

}*/