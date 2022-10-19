package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Informacion de la operacion o del tipo de movimiento")
public class TipomovimientoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Codigo identificador del codigo
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Codigo identificador del codigo")
    private Long codigo;


    /**
     * Nombre del movimiento u operacion
     */
    @NotNull(message = "nombre can not null")
    @ApiModelProperty("Nombre del movimiento u operacion")
    private String nombre;


    /**
     * Operacion aritmetica suma (1) resta (2)
     */
    @ApiModelProperty("Operacion aritmetica suma (1) resta (2)")
    private Integer tipooperacion;

}
