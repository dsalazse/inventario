package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Entidad de rompimiento entre grupo y dato")
public class GrupodatoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria de grupodato
     */
    @NotNull(message = "id can not null")
    @ApiModelProperty("Llave primaria de grupodato")
    private Long id;


    /**
     * Relacion foranea con grupo
     */
    @NotNull(message = "grupofk can not null")
    @ApiModelProperty("Relacion foranea con grupo")
    private Long grupofk;


    /**
     * Relacion foranea con dato
     */
    @NotNull(message = "datofk can not null")
    @ApiModelProperty("Relacion foranea con dato")
    private Long datofk;

}
