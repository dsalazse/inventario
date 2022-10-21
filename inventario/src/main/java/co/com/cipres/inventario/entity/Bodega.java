package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Informacion de la bodega(caja)
 */
@Data
@Entity
@Table(name = "bodega", schema = "inventario")
@ApiModel("Informacion de la bodega(caja)")
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador de la bodega(caja)
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Codigo identificador de la bodega(caja)")
    private Long codigo;

    /**
     * Auto enlace de la bodega(caja)
     */
    @Column(name = "referencia")
    @ApiModelProperty("Auto enlace de la bodega(caja)")
    private Long referencia;

    /**
     * Compania a la que pertenece la bodega(caja)
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("Compania a la que pertenece la bodega(caja)")
    private Long compania;

    @Column(name = "identificacion", nullable = false)
    private String identificacion;

    /**
     * Nombre de la bodega(caja)
     */
    @Column(name = "nombre")
    @ApiModelProperty("Nombre de la bodega(caja)")
    private String nombre;

    /**
     * Nivel de la bodega(caja)
     */
    @Column(name = "nivel", nullable = false)
    @ApiModelProperty("Nivel de la bodega(caja)")
    private Integer nivel;

}
