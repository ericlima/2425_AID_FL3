package pt.ipcb.ad.ficha3.model

import jakarta.persistence.*
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@Entity
@Table(name = "CLIENTE")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "NOME", length = 100)
    var nome: String,
    @Column(name = "EmAIL", length = 255)
    var email: String,
    @Column(name = "MORADA", length = 100)
    var morada: String,
    @Column(name = "DATA_NASC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var dataNasc: LocalDate,
    @Column(name = "NIF", nullable = false)
    var nif: String,
) {
}