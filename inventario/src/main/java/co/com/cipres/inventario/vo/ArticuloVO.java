package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Inventario de servicios articulos")
public class ArticuloVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria del inventario
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Llave primaria del inventario")
    private Long codigo;


    /**
     * Descripcion del inventario
     */
    @NotNull(message = "descripcion can not null")
    @ApiModelProperty("Descripcion del inventario")
    private String descripcion;


    /**
     * Compania del inventario
     */
    @NotNull(message = "compania can not null")
    @ApiModelProperty("Compania del inventario")
    private Long compania;

    @NotNull(message = "usuarioaud can not null")
    private Long usuarioaud;

    @NotNull(message = "fechahoraud can not null")
    private Date fechahoraud;

}
