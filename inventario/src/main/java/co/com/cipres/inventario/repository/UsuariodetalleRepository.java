package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Usuariodetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuariodetalleRepository extends JpaRepository<Usuariodetalle, Long>, JpaSpecificationExecutor<Usuariodetalle> {

}