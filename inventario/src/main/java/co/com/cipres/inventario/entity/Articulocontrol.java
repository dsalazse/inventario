package co.com.cipres.inventario.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "articulocontrol")
public class Articulocontrol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "articulo", nullable = false)
    private Long articulo;

    @Column(name = "maximo", nullable = false)
    private Long maximo;

    @Column(name = "minimo", nullable = false)
    private Long minimo;

}
