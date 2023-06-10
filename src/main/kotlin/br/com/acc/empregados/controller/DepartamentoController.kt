package br.com.acc.empregados.controller

import br.com.acc.empregados.model.Departamento
import br.com.acc.empregados.service.DepartamentoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("departamento")
class DepartamentoController(val service: DepartamentoService) {
    @GetMapping
    fun findAll(): List<Departamento> = service.getAll()

    @PostMapping
    fun post(@RequestBody departamento: Departamento) : ResponseEntity<String> {
        service.create(departamento)
        return ResponseEntity("inserido com sucesso", HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Int, @RequestBody departamento: Departamento): ResponseEntity<String> {
        val deptoUpdate = service.update(id, departamento)

        return if(deptoUpdate.deptno == null) {
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
