package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad para guardar usuarios autorizados al servicio")
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Identificador exclusivo del usuario
     */
    @ApiModelProperty("Identificador exclusivo del usuario")
    private Long codigo;


    /**
     * correo electronico identificador del usuario
     */
    @ApiModelProperty("correo electronico identificador del usuario")
    private String email;


    /**
     * contrasena para acceder al servicio
     */
    @ApiModelProperty("contrasena para acceder al servicio")
    private String contrasena;

}
