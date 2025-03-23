package pt.ipcb.ad.ficha3.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "PRODUTO")
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(name = "DESCRICAO", length = 100)
    var descricao: String,
    @Column(name = "PRECO_UNITARIO")
    var precoUnitario: BigDecimal,
) {
}