package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
@Data
@ApiModel("Save Terceros participan en alguna transaccion")
public class TerceroVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Codigo identificador unico de un tercero
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Codigo identificador unico de un tercero")
    private Long codigo;


    /**
     * Relacion con la tabla grupodato
     */
    @NotNull(message = "tipodocumento can not null")
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Integer tipodocumento;


    /**
     * Numero de documento
     */
    @NotNull(message = "numero can not null")
    @ApiModelProperty("Numero de documento")
    private String numero;

}
