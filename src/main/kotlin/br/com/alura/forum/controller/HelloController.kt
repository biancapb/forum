package br.com.alura.forum.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello") //identificar no navegador
class HelloController {

    @GetMapping //requisição do tipo Get
    fun hello(): String {
        return "funcionaaaaa Hello World! ALTERADO"
    }
}