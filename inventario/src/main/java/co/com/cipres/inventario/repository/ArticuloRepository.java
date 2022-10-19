package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticuloRepository extends JpaRepository<Articulo, Long>, JpaSpecificationExecutor<Articulo> {

}