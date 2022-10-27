package co.com.cipres.inventario.dto.reports;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel("Entidad que contiene informacion para Grupodato en reporte")
public class GrupodatoReportsDTO implements Serializable {

    private static final long serialVersionUID = 6367868246366707299L;

    /**
     * Llave primaria de grupo
     */
    @ApiModelProperty("Llave primaria de grupo en reporte")
    private Long idGrupo;


    /**
     * Nombre del dato
     */
    @ApiModelProperty("Nombre del grupo en reporte")
    private String descripcionGrupo;

    /**
     * Llave primaria de dato
     */
    @ApiModelProperty("Llave primaria de dato en reporte")
    private Long idDato;


    /**
     * Nombre del dato
     */
    @ApiModelProperty("Nombre del dato en reporte")
    private String descripcionDato;




    /**
     * Compañia a la que pertenece el dato
     */
    @ApiModelProperty("Compañia a la que pertenece el dato en Reporte")
    private Long companiaDato;

    /**
     * Nombre de la compania
     */
    @ApiModelProperty("Nombre de la compania en Dato")
    private String nombreCompaniaDato;


    /**
     * Compania a la que pertenece el grupo
     */
    @ApiModelProperty("Compania a la que pertenece el grupo")
    private Long companiaGrupo;

    /**
     * Nombre de la compania
     */
    @ApiModelProperty("Nombre de la compania en grupo")
    private String nombreCompaniaGrupo;

}
