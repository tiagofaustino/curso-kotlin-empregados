package br.com.acc.empregados.repository

import br.com.acc.empregados.model.Funcionario
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface FuncionarioRepository : CrudRepository<Funcionario, String> {

    @Query(value = "select * from emp", nativeQuery = true)
    fun findFuncionarios(): List<Funcionario>
}