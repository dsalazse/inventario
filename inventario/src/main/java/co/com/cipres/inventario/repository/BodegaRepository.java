package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BodegaRepository extends JpaRepository<Bodega, Long>, JpaSpecificationExecutor<Bodega> {

}