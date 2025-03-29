package pt.ipcb.ad.ficha3.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pt.ipcb.ad.ficha3.model.Cliente
import pt.ipcb.ad.ficha3.service.ClienteRepository
import java.util.*

@RestController
@RequestMapping("/api/v1/clientes")
class ClientesV1Controller(val clienteRepository: ClienteRepository) {

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): ResponseEntity<Cliente> {
        val cliente: Optional<Cliente> = clienteRepository.findById(id)

        return if (cliente.isPresent) {
            ResponseEntity.ok(cliente.get()) // 200 OK
        } else {
            ResponseEntity.notFound().build() // 404 Not Found
        }
    }

    @GetMapping()
    fun getAll(): ResponseEntity<List<Cliente>> {
        val clientes = clienteRepository.findAll()
        return if (clientes.isEmpty()) {
            ResponseEntity.noContent().build() // HTTP 204
        } else {
            ResponseEntity.ok(clientes) // HTTP 200
        }
    }

    @PostMapping()
    fun add(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val clienteAdded: Cliente = clienteRepository.save(cliente)
        return ResponseEntity.ok(clienteAdded)
    }

    @PutMapping()
    fun update(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val clienteExists: Boolean = clienteRepository.findById(cliente.id).isPresent
        if (clienteExists) {
            val clienteUpdated: Cliente = clienteRepository.save(cliente)
            return ResponseEntity.ok(clienteUpdated)
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateClienteName(
        @PathVariable clienteId: Long,
        @RequestBody nome: String
    ): Cliente {
        val atualizado = clienteRepository.atualizarNomePorId(clienteId, nome)

        if (atualizado == 0) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        }

        return clienteRepository.findById(clienteId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        }
    }
}