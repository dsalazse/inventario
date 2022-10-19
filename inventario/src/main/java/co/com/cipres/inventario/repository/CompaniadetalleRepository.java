package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Companiadetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompaniadetalleRepository extends JpaRepository<Companiadetalle, Long>, JpaSpecificationExecutor<Companiadetalle> {

}