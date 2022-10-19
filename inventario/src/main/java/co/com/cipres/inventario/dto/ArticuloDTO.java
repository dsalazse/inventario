package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("Inventario de servicios articulos")
public class ArticuloDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria del inventario
     */
    @ApiModelProperty("Llave primaria del inventario")
    private Long codigo;


    /**
     * Descripcion del inventario
     */
    @ApiModelProperty("Descripcion del inventario")
    private String descripcion;


    /**
     * Compania del inventario
     */
    @ApiModelProperty("Compania del inventario")
    private Long compania;

    private Long usuarioaud;

    private Date fechahoraud;

}
