package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Inventario de servicios articulos el detalle
 */
@Data
@Entity
@Table(name = "articulodetalle")
@ApiModel("Inventario de servicios articulos el detalle")
public class Articulodetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria del detalle de inventario
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @ApiModelProperty("Llave primaria del detalle de inventario")
    private Long codigo;

    /**
     * Llave foranea que va a la tabla articulo
     */
    @Column(name = "articulo", nullable = false)
    @ApiModelProperty("Llave foranea que va a la tabla articulo")
    private Long articulo;

    /**
     * Llave foranea que va a la tabla de grupo dato
     */
    @Column(name = "caracteristica", nullable = false)
    @ApiModelProperty("Llave foranea que va a la tabla de grupo dato")
    private Long caracteristica;

    /**
     * Valor asociado a la caracteristica
     */
    @Column(name = "valor")
    @ApiModelProperty("Valor asociado a la caracteristica")
    private String valor;

}
