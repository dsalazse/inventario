package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Grupodato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GrupodatoRepository extends JpaRepository<Grupodato, Long>, JpaSpecificationExecutor<Grupodato> {

}