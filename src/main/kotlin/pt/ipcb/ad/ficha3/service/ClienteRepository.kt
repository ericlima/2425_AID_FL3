package pt.ipcb.ad.ficha3.service

import org.springframework.data.jpa.repository.JpaRepository
import pt.ipcb.ad.ficha3.model.Cliente
import java.util.*

interface ClienteRepository : JpaRepository<Cliente, Long>   {

    override fun findById(id: Long): Optional<Cliente>

}