package pt.ipcb.ad.ficha3.model

import jakarta.persistence.*

@Entity
@Table(name = "PEDIDO_ITEM")
data class PedidoItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(name = "QUANTIDADE")
    var quantidade: Int,
    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    var pedido: Pedido,
    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    var produto: Produto,
) {
}