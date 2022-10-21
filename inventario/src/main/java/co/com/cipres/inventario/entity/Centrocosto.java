package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Informacion del centro de costo
 */
@Data
@Entity
@Table(name = "centrocosto", schema = "inventario")
@ApiModel("Informacion del centro de costo")
public class Centrocosto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador del centro de costo
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Codigo identificador del centro de costo")
    private Long codigo;

    /**
     * Auto enlace del centro de costo
     */
    @Column(name = "referencia")
    @ApiModelProperty("Auto enlace del centro de costo")
    private Long referencia;

    /**
     * Compania a la que pertenece la bodega(caja)
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("Compania a la que pertenece el centro de costo")
    private Long compania;

    /**
     * Nombre del centro del costo
     */
    @Column(name = "nombre", nullable = false)
    @ApiModelProperty("Nombre del centro del costo")
    private String nombre;

    /**
     * Nivel del centro de costo
     */
    @Column(name = "nivel", nullable = false)
    @ApiModelProperty("Nivel del centro de costo")
    private Integer nivel;

}
