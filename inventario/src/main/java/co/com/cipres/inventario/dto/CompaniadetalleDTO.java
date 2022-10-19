package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Define detalles de una compania comercial")
public class CompaniadetalleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * identificador de  compania detalle
     */
    @ApiModelProperty("identificador de  compania detalle")
    private Long codigo;


    /**
     * enlace a la tabla compania
     */
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;


    /**
     * enlace a la tabla grupodato
     */
    @ApiModelProperty("enlace a la tabla grupodato")
    private Long caracteristica;


    /**
     * valor que corresponde con la informacion grupodato
     */
    @ApiModelProperty("valor que corresponde con la informacion grupodato")
    private String valor;

}
