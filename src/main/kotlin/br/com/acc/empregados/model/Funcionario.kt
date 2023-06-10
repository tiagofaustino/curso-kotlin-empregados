package br.com.acc.empregados.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "emp")
data class Funcionario(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
    @JsonProperty(value = "empno", access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "empno")
    var numeroEmpregado: Int? = null,

    @Column(name = "ename", length = 10)
    @JsonProperty(value = "ename")
    var nome: String? = null,

    @Column(length = 9)
    var job: String? = null,

    @Column
    var mgr: Int? = null,

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    var hiredate: Date? = null,

    @Column(name = "sal")
    @JsonProperty(value = "sal")
    var salario: BigDecimal? = null,

    @Column(name = "comm")
    @JsonProperty(value = "comm")
    var comissao: BigDecimal? = null
)