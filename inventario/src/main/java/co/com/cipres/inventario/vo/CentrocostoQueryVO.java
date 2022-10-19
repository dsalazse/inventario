package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query Informacion del centro de costo")
public class CentrocostoQueryVO implements Serializable {
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
