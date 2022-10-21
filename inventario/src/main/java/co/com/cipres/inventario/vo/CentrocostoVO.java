package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotNull;


@Data
@ApiModel("Save Informacion del centro de costo")
public class CentrocostoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Codigo identificador del centro de costo
     */
    @NotNull(message = "codigo can not null")
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
    @NotNull(message = "compania can not null")
    @ApiModelProperty("Compania a la que pertenece el centro de costo")
    private Long compania;


    /**
     * Nombre del centro del costo
     */
    @NotNull(message = "nombre can not null")
    @ApiModelProperty("Nombre del centro del costo")
    private String nombre;


    /**
     * Nivel del centro de costo
     */
    @NotNull(message = "nivel can not null")
    @ApiModelProperty("Nivel del centro de costo")
    private Integer nivel;

}
