package pt.ipcb.ad.ficha3.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pt.ipcb.ad.ficha3.model.Pedido
import pt.ipcb.ad.ficha3.service.ClienteRepository
import pt.ipcb.ad.ficha3.service.PedidoRepository

@RestController
@RequestMapping("/api/v0/pedidos")
class PedidosV0Controller(
    val pedidoRepository: PedidoRepository,
    val clienteRepository: ClienteRepository
) {

     @PostMapping()
     @ResponseStatus(HttpStatus.CREATED)
     fun add(@RequestBody pedido: Pedido): Pedido {
         val clienteExists = clienteRepository.findById(pedido.cliente!!.id)
         return pedidoRepository.save(pedido)
     }
}