package br.com.acc.empregados.controller

import br.com.acc.empregados.model.Funcionario
import br.com.acc.empregados.service.FuncionarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("funcionario")
class FuncionarioController(val service: FuncionarioService) {
    @GetMapping
    fun findAll(): List<Funcionario> = service.getAll()

    @PostMapping
    fun post(@RequestBody funcionario: Funcionario) : ResponseEntity<String> {
        service.create(funcionario)
        return ResponseEntity("inserido com sucesso", HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody funcionario: Funcionario): ResponseEntity<String> {
        val deptoUpdate = service.update(id, funcionario)

        return if(deptoUpdate.numeroEmpregado == null) {
            ResponseEntity("não foi encontrado o id: $id", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("update feito no id: $id", HttpStatus.OK)
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }
}
