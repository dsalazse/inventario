package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Informacion de la operacion o del tipo de movimiento")
public class TipomovimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador del codigo
     */
    @ApiModelProperty("Codigo identificador del codigo")
    private Long codigo;


    /**
     * Nombre del movimiento u operacion
     */
    @ApiModelProperty("Nombre del movimiento u operacion")
    private String nombre;


    /**
     * Operacion aritmetica suma (1) resta (2)
     */
    @ApiModelProperty("Operacion aritmetica suma (1) resta (2)")
    private Integer tipooperacion;

}
