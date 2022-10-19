package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Informacion de la bodega(caja)")
public class BodegaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Codigo identificador de la bodega(caja)
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Codigo identificador de la bodega(caja)")
    private Long codigo;


    /**
     * Auto enlace de la bodega(caja)
     */
    @ApiModelProperty("Auto enlace de la bodega(caja)")
    private Long referencia;

    @NotNull(message = "identificacion can not null")
    private String identificacion;


    /**
     * Nombre de la bodega(caja)
     */
    @ApiModelProperty("Nombre de la bodega(caja)")
    private String nombre;


    /**
     * Nivel de la bodega(caja)
     */
    @NotNull(message = "nivel can not null")
    @ApiModelProperty("Nivel de la bodega(caja)")
    private Integer nivel;

}
