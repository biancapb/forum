package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid
import javax.websocket.server.PathParam

/*CONTROLLER: receber as requisições dos clientes e fazer a manipulação*/

@RestController /*não trabalha com navegação de páginas e renderização server-side, apenas recebe dados e devolve dados*/
@RequestMapping("/topicos") /*todos Controllers precisam dizer qual é o endereço, a URI*/
class TopicoController(private val service: TopicoService) {
    @GetMapping /*se chegar uma requição para topicos e for um get, cairá nesse método*/
    fun listar(): List<TopicoView> /*lista os tópicos*/ {
        return service.listar()
    }

    /*endereço para cada id*/
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long) : TopicoView {
        return service.buscarPorId(id)
    }

    /*postando informação*/
    @PostMapping
    fun cadastrar (
        @RequestBody @Valid form: TopicoForm, /*procurar as informações necessárias para criar o objeto topico no corpo da requisição*/
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm) : ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}