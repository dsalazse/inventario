package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Tipomovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipomovimientoRepository extends JpaRepository<Tipomovimiento, Long>, JpaSpecificationExecutor<Tipomovimiento> {

}