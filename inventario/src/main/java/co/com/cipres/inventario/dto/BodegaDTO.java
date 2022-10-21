package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Informacion de la bodega(caja)")
public class BodegaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador de la bodega(caja)
     */
    @ApiModelProperty("Codigo identificador de la bodega(caja)")
    private Long codigo;


    /**
     * Auto enlace de la bodega(caja)
     */
    @ApiModelProperty("Auto enlace de la bodega(caja)")
    private Long referencia;

    /**
     * Compania a la que pertenece la bodega(caja)
     */
    @ApiModelProperty("Compania a la que pertenece la bodega(caja)")
    private Long compania;

    @ApiModelProperty("Codigo numero identificador de la bodega")
    private String identificacion;

    /**
     * Nombre de la bodega(caja)
     */
    @ApiModelProperty("Nombre de la bodega(caja)")
    private String nombre;

    /**
     * Nivel de la bodega(caja)
     */
    @ApiModelProperty("Nivel de la bodega(caja)")
    private Integer nivel;

}
