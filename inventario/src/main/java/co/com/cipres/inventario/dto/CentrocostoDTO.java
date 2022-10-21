package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Informacion del centro de costo")
public class CentrocostoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador del centro de costo
     */
    @ApiModelProperty("Codigo identificador del centro de costo")
    private Long codigo;


    /**
     * Auto enlace del centro de costo
     */
    @ApiModelProperty("Auto enlace del centro de costo")
    private Long referencia;

    /**
     * Compania a la que pertenece el centro de costo
     */
    @ApiModelProperty("Compania a la que pertenece el centro de costo")
    private Long compania;


    /**
     * Nombre del centro del costo
     */
    @ApiModelProperty("Nombre del centro del costo")
    private String nombre;


    /**
     * Nivel del centro de costo
     */
    @ApiModelProperty("Nivel del centro de costo")
    private Integer nivel;

}
