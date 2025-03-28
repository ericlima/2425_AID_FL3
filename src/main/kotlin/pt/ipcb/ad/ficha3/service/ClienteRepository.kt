package pt.ipcb.ad.ficha3.service

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import pt.ipcb.ad.ficha3.model.Cliente
import java.time.LocalDate
import java.util.*

interface ClienteRepository : JpaRepository<Cliente, Long>   {

    override fun findById(id: Long): Optional<Cliente>

    fun findByNome(nome: String): List<Cliente>
    fun findByNomeAndDataNasc(nome: String, dataNasc: LocalDate): List<Cliente>
    fun findByNomeLikeOrderByNomeAsc(nome: String): List<Cliente>



    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    fun buscarPorIdJPQL(@Param("id") id: Long): Cliente?

    @Query("SELECT c FROM Cliente c ORDER BY c.id ")
    fun getClientesJPQL(): List<Cliente>

     @Query("SELECT c FROM Cliente c WHERE c.nome like :nome ")
     fun getByNomeJPQL(nome: String): List<Cliente>

    //@Query("update Cliente c set  where c.nome = :nome")

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.nome = :nome WHERE c.id = :id")
    fun atualizarNomePorId(@Param("id") id: Long, @Param("nome") nome: String): Int

}