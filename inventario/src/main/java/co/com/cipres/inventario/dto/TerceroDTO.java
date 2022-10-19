package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Terceros participan en alguna transaccion")
public class TerceroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador unico de un tercero
     */
    @ApiModelProperty("Codigo identificador unico de un tercero")
    private Long codigo;


    /**
     * Relacion con la tabla grupodato
     */
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Integer tipodocumento;


    /**
     * Numero de documento
     */
    @ApiModelProperty("Numero de documento")
    private String numero;

}
