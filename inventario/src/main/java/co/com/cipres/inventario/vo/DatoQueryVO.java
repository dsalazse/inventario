package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query Entidad que contiene un dato")
public class DatoQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Identificador del dato")
    private Long id;

    @ApiModelProperty("Nombre del dato")
    private String descripcion;


    /**
     * Compañia a la que pertenece el dato
     */
    @ApiModelProperty("Compañia a la que pertenece el dato")
    private Long compania;

}
