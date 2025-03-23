package pt.ipcb.ad.ficha3.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "PEDIDO")
data class Pedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(name = "DATA_PEDIDO")
    var dataPedido: LocalDateTime,
    @Column(name = "TOTAL")
    var total: BigDecimal,
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    var cliente: Cliente?,
) {

}