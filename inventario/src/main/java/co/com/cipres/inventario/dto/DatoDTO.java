package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad que contiene un dato")
public class DatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Llave primaria de dato")
    private Long id;

    @ApiModelProperty("Nombre del dato")
    private String descripcion;


    /**
     * Compañia a la que pertenece el dato
     */
    @ApiModelProperty("Compañia a la que pertenece el dato")
    private Long compania;

}
