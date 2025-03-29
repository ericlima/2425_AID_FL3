package pt.ipcb.ad.ficha3.controller

import org.springframework.web.bind.annotation.*
import pt.ipcb.ad.ficha3.model.Cliente
import pt.ipcb.ad.ficha3.service.ClienteRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v0/clientes")
class ClienteV0Controller(val clienteRepository: ClienteRepository) {

    @PostMapping()
    fun add(@RequestBody cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    @GetMapping(name="/{id}")
    fun getOne(@PathVariable id: Long): Cliente {
        return clienteRepository.findById(id).get()
    }

    @GetMapping(name="/nome/{nome}")
    fun getByNome(@PathVariable nome: String): List<Cliente> {
        return clienteRepository.findByNome(nome)
    }

    @GetMapping(name="/busca_nome_e_data_nasc")
    fun getByNomeAndDataNasc(
        @RequestParam nome: String,
        @RequestParam dataNasc: String
        ): List<Cliente> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // ou outro formato que estiver usando
        val dataNascimento = LocalDate.parse(dataNasc, formatter)

        return clienteRepository.findByNomeAndDataNasc(nome, dataNascimento)
    }

    @PutMapping()
    fun update(@RequestBody cliente: Cliente): Cliente {
        val existe: Boolean = clienteRepository.findById(cliente.id).isPresent
        if (existe) {
            clienteRepository.save(cliente)
        }
        return cliente
    }

    @DeleteMapping(name="/{id}")
    fun delete(@PathVariable id: Long): Boolean {
        val cliente = clienteRepository.findById(id)
        if (!cliente.isPresent) {
            return false
        }
        clienteRepository.deleteById(id)
        return true
    }


}