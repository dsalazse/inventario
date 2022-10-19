package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query Entidad de rompimiento entre grupo y dato")
public class GrupodatoQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria de grupodato
     */
    @ApiModelProperty("Llave primaria de grupodato")
    private Long id;


    /**
     * Relacion foranea con grupo
     */
    @ApiModelProperty("Relacion foranea con grupo")
    private Long grupofk;


    /**
     * Relacion foranea con dato
     */
    @ApiModelProperty("Relacion foranea con dato")
    private Long datofk;

}
