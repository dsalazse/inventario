package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Articulocontrol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticulocontrolRepository extends JpaRepository<Articulocontrol, Long>, JpaSpecificationExecutor<Articulocontrol> {

}