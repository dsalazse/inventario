package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>, JpaSpecificationExecutor<Transaccion> {

}