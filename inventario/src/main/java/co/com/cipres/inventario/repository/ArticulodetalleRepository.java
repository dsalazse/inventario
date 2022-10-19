package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Articulodetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticulodetalleRepository extends JpaRepository<Articulodetalle, Long>, JpaSpecificationExecutor<Articulodetalle> {

}