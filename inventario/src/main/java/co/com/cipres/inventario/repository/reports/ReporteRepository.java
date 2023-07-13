package co.com.cipres.inventario.repository.reports;

import co.com.cipres.inventario.entity.Grupodato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReporteRepository extends JpaRepository<Grupodato, Long>, JpaSpecificationExecutor<Grupodato> {
    /*
    *   proposito: retornar todos los datos de las tablas: grupo, dato, grupodato
    *
    * */
    @Query(name = "queryAllGrupoDatoReport", value = "select gd.* from inventario.grupo g, inventario.grupodato gd, inventario.dato d " +
            "  where gd.grupofk  = g.id " +
            "    and gd.datofk   = d.id", nativeQuery = true)
    List<Grupodato> queryAllGrupoDatoReport();
}
