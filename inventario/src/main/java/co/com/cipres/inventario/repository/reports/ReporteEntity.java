package co.com.cipres.inventario.repository.reports;

import co.com.cipres.inventario.dto.reports.GrupodatoReportsDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ReporteEntity {
    @PersistenceContext
    private EntityManager entityManager;

    /*
    *   proposito: retornar todos los datos de las tablas: grupo, dato, grupodato
    *
    * */
    public List<GrupodatoReportsDTO> queryAllGrupoDatoReport(){
        Query nativeQuery = entityManager.createNativeQuery("select  g.id idGrupo, g.descripcion descripcionGrupo, " +
                "d.id idDato, d.descripcion descripcionDato, c.nombre companiaDato " +
                " from  inventario.grupo g," +
                " inventario.dato d," +
                " inventario.grupodato gd, " +
                " inventario.compania c " +
                " where   gd.grupofk   = g.id" +
                " and   gd.datofk      = d.id " +
                " and   g.compania     = c.codigo" +
                " and   d.compania     = c.codigo"
        );
        return nativeQuery.getResultList();
    }

}
