package co.com.cipres.inventario.repository;

import co.com.cipres.inventario.entity.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompaniaRepository extends JpaRepository<Compania, Long>, JpaSpecificationExecutor<Compania> {

}