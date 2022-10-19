package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query Terceros informacion detallada")
public class TercerodetalleQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria unico de tercero detalle
     */
    @ApiModelProperty("Llave primaria unico de tercero detalle")
    private Long codigo;


    /**
     * Relacion con la tabla tercero
     */
    @ApiModelProperty("Relacion con la tabla tercero")
    private Long tercero;


    /**
     * Relacion con la tabla grupodato
     */
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Long caracteristica;


    /**
     * Informacion sobre la caracteristica
     */
    @ApiModelProperty("Informacion sobre la caracteristica")
    private String valor;

}
