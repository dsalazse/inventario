package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Tercero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TerceroRepository extends JpaRepository<Tercero, Long>, JpaSpecificationExecutor<Tercero> {

}