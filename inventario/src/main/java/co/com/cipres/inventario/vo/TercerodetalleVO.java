package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Terceros informacion detallada")
public class TercerodetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria unico de tercero detalle
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Llave primaria unico de tercero detalle")
    private Long codigo;


    /**
     * Relacion con la tabla tercero
     */
    @NotNull(message = "tercero can not null")
    @ApiModelProperty("Relacion con la tabla tercero")
    private Long tercero;


    /**
     * Relacion con la tabla grupodato
     */
    @NotNull(message = "caracteristica can not null")
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Long caracteristica;


    /**
     * Informacion sobre la caracteristica
     */
    @NotNull(message = "valor can not null")
    @ApiModelProperty("Informacion sobre la caracteristica")
    private String valor;

}
