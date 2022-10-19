package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Define detalles de una compania comercial
 */
@Data
@Entity
@Table(name = "companiadetalle", schema = "inventario")
@ApiModel("Define detalles de una compania comercial")
public class Companiadetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identificador de  compania detalle
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("identificador de  compania detalle")
    private Long codigo;

    /**
     * enlace a la tabla compania
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;

    /**
     * enlace a la tabla grupodato
     */
    @ApiModelProperty("enlace a la tabla grupodato")
    @Column(name = "caracteristica", nullable = false)
    private Long caracteristica;

    /**
     * valor que corresponde con la informacion grupodato
     */
    @Column(name = "valor", nullable = false)
    @ApiModelProperty("valor que corresponde con la informacion grupodato")
    private String valor;

}
