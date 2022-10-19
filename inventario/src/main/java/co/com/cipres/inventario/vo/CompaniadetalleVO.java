package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Define detalles de una compania comercial")
public class CompaniadetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * identificador de  compania detalle
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("identificador de  compania detalle")
    private Long codigo;


    /**
     * enlace a la tabla compania
     */
    @NotNull(message = "compania can not null")
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;


    /**
     * enlace a la tabla grupodato
     */
    @NotNull(message = "caracteristica can not null")
    @ApiModelProperty("enlace a la tabla grupodato")
    private Long caracteristica;


    /**
     * valor que corresponde con la informacion grupodato
     */
    @NotNull(message = "valor can not null")
    @ApiModelProperty("valor que corresponde con la informacion grupodato")
    private String valor;

}
