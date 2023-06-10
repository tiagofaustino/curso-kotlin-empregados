package br.com.acc.empregados.service

import br.com.acc.empregados.model.Funcionario
import br.com.acc.empregados.repository.FuncionarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioService(val db: FuncionarioRepository) {
    fun getAll(): List<Funcionario> = db.findFuncionarios()

    fun getById(id: Int): Optional<Funcionario> {
        return db.findById(id.toString())
    }

    fun create(funcionario: Funcionario) {
        db.save(funcionario)
    }

    fun existsById(id: Int): Boolean {
        return db.existsById(id.toString())
    }

    fun update(id: Int, funcionario: Funcionario): Funcionario {
        if(db.existsById(id.toString())) {
            val safeFuncionario = funcionario.copy(numeroEmpregado = id)
            return db.save(safeFuncionario)
        }
        return Funcionario()
    }

    fun delete(id: Int) {
        if(db.existsById(id.toString())) {
            db.deleteById(id.toString())
        }
    }
}