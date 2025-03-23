package pt.ipcb.ad.ficha3.service

import org.springframework.data.jpa.repository.JpaRepository
import pt.ipcb.ad.ficha3.model.Pedido

interface PedidoRepository : JpaRepository<Pedido, Long> {
}
