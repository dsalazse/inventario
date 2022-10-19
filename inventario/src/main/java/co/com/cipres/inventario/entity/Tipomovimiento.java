package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Informacion de la operacion o del tipo de movimiento
 */
@Data
@Entity
@Table(name = "tipomovimiento", schema = "inventario")
@ApiModel("Informacion de la operacion o del tipo de movimiento")
public class Tipomovimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador del codigo
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Codigo identificador del codigo")
    private Long codigo;

    /**
     * Nombre del movimiento u operacion
     */
    @Column(name = "nombre", nullable = false)
    @ApiModelProperty("Nombre del movimiento u operacion")
    private String nombre;

    /**
     * Operacion aritmetica suma (1) resta (2)
     */
    @Column(name = "tipooperacion")
    @ApiModelProperty("Operacion aritmetica suma (1) resta (2)")
    private Integer tipooperacion;

}
