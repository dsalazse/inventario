package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad que agrupa informacion")
public class GrupoDTO implements Serializable {
    private static final long serialVersionUID = 901621583924807625L;

    /**
     * Llave primaria de grupo
     */
    @ApiModelProperty("Llave primaria de grupo")
    private Long id;


    /**
     * Nombre del dato
     */
    @ApiModelProperty("Nombre del grupo")
    private String descripcion;

    /**
     * Compania a la que pertenece el grupo
     */
    @ApiModelProperty("Compania a la que pertenece el grupo")
    private Long compania;

}
