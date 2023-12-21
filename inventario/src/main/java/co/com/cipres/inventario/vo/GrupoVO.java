package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Entidad que agrupa informacion")
public class GrupoVO implements Serializable {
    private static final long serialVersionUID = -2685907500098780707L;

    /**
     * Llave primaria de dato
     */
    @NotNull(message = "id can not null")
    @ApiModelProperty("Llave primaria de dato")
    private Long id;


    /**
     * Nombre del dato
     */
    @NotNull(message = "descripcion can not null")
    @ApiModelProperty("Nombre del dato")
    private String descripcion;

    /**
     * Compania a la que pertenece el grupo
     */
    @NotNull(message = "compania can not null")
    @ApiModelProperty("Compania a la que pertenece el grupo")
    private Long compania;

}
