package pt.ipcb.ad.ficha3.service

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import pt.ipcb.ad.ficha3.model.Cliente

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
) {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Transactional
    fun save(clienteParam: Cliente): Cliente {
        entityManager.persist(clienteParam)
        return clienteParam
    }

}
