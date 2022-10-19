package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Inventario de servicios articulos el detalle")
public class ArticulodetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria del detalle de inventario
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Llave primaria del detalle de inventario")
    private Long codigo;


    /**
     * Llave foranea que va a la tabla articulo
     */
    @NotNull(message = "articulo can not null")
    @ApiModelProperty("Llave foranea que va a la tabla articulo")
    private Long articulo;


    /**
     * Llave foranea que va a la tabla de grupo dato
     */
    @NotNull(message = "caracteristica can not null")
    @ApiModelProperty("Llave foranea que va a la tabla de grupo dato")
    private Long caracteristica;


    /**
     * Valor asociado a la caracteristica
     */
    @ApiModelProperty("Valor asociado a la caracteristica")
    private String valor;

}
