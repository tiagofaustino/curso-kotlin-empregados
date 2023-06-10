package br.com.acc.empregados.repository

import br.com.acc.empregados.model.Departamento
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface DepartamentoRepository : CrudRepository<Departamento, String> {

    @Query(value = "select deptno, dname, loc from dept", nativeQuery = true)
    fun findDepartamentos(): List<Departamento>
}