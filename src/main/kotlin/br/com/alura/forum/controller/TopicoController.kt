package br.com.alura.forum.controller

import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/*CONTROLLER: receber as requisições dos clientes e fazer a manipulação*/

@RestController /*não trabalha com navegação de páginas e renderização server-side, apenas recebe dados e devolve dados*/
@RequestMapping("/topicos") /*todos Controllers precisam dizer qual é o endereço, a URI*/
class TopicoController(private val service: TopicoService) {
    @GetMapping /*se chegar uma requição para topicos e for um get, cairá nesse método*/
    fun listar(): List<Topico> /*lista os tópicos*/ {
        return service.listar()
    }

    /*endereço para cada id*/
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long) : Topico {
        return service.listarPorId(id)
    }
}