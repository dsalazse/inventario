package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save Entidad que contiene un dato")
public class DatoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "descripcion can not null")
    private String descripcion;


    /**
     * Compañia a la que pertenece el dato
     */
    @ApiModelProperty("Compañia a la que pertenece el dato")
    private Long compania;

}
