package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Datovalidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DatovalidadorRepository extends JpaRepository<Datovalidador, Long>, JpaSpecificationExecutor<Datovalidador> {

}