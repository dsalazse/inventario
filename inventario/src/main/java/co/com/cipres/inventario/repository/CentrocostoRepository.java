package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Centrocosto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CentrocostoRepository extends JpaRepository<Centrocosto, Long>, JpaSpecificationExecutor<Centrocosto> {

}