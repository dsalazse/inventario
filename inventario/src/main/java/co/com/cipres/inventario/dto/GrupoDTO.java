package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad que agrupa informacion")
public class GrupoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria de dato
     */
    @ApiModelProperty("Llave primaria de dato")
    private Long id;


    /**
     * Nombre del dato
     */
    @ApiModelProperty("Nombre del dato")
    private String descripcion;

}
