package br.com.acc.empregados.service

import br.com.acc.empregados.model.Departamento
import br.com.acc.empregados.repository.DepartamentoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartamentoService(val db: DepartamentoRepository) {
    fun getAll(): List<Departamento> = db.findDepartamentos()

    fun getById(id: Int): Optional<Departamento> {
        return db.findById(id.toString())
    }

    fun create(departamento: Departamento) {
        db.save(departamento)
    }

    fun existsById(id: Int): Boolean {
        return db.existsById(id.toString())
    }

    fun update(id: Int, departamento: Departamento): Departamento {
        if(db.existsById(id.toString())) {
            val safeDepartamento = departamento.copy(deptno = id)
            return db.save(safeDepartamento)
        }
        return Departamento()
    }

    fun delete(id: Int) {
        if(db.existsById(id.toString())) {
            db.deleteById(id.toString())
        }
    }
}