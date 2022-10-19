package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad para guardar detalle de usuarios autorizados al servicio")
public class UsuariodetalleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Identificador exclusivo del detalle del usuario
     */
    @ApiModelProperty("Identificador exclusivo del detalle del usuario")
    private Long codigo;


    /**
     * Llave foranea a tabla usuario
     */
    @ApiModelProperty("Llave foranea a tabla usuario")
    private Long usuario;


    /**
     * Nombre(s) del usuario
     */
    @ApiModelProperty("Nombre(s) del usuario")
    private String nombre;


    /**
     * Apellidos(s) del usuario
     */
    @ApiModelProperty("Apellidos(s) del usuario")
    private String apellido;


    /**
     * enlace a la tabla compania
     */
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;

}
