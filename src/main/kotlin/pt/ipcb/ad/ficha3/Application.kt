package pt.ipcb.ad.ficha3

import org.apache.catalina.core.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import pt.ipcb.ad.ficha3.model.Cliente
import pt.ipcb.ad.ficha3.model.Pedido
import pt.ipcb.ad.ficha3.model.PedidoItem
import pt.ipcb.ad.ficha3.model.Produto
import pt.ipcb.ad.ficha3.service.ClienteRepository
import pt.ipcb.ad.ficha3.service.PedidoItemRepository
import pt.ipcb.ad.ficha3.service.PedidoRepository
import pt.ipcb.ad.ficha3.service.ProdutoRepository
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)

    // Obter beans manualmente do contexto
    val clienteRepository = context.getBean(ClienteRepository::class.java)
    val pedidoRepository = context.getBean(PedidoRepository::class.java)
    val produtoRepository = context.getBean(ProdutoRepository::class.java)
    val pedidoItemRepository = context.getBean(PedidoItemRepository::class.java)

    val cliente1: Optional<Cliente> = clienteRepository.findById(1L)
    var pedido1 = Pedido(null, LocalDateTime.now(), BigDecimal(1000), cliente1.get())

    pedido1 = pedidoRepository.save(pedido1)

    var produto = Produto(null, "Peoduto 1", BigDecimal(1))

    produto = produtoRepository.save(produto)

    var pedidoItem = PedidoItem(null, 1000, pedido1, produto)

    pedidoItemRepository.save(pedidoItem)


}
