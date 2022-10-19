package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
@Data
@ApiModel("Save Entidad para guardar usuarios autorizados al servicio")
public class UsuarioVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Identificador exclusivo del usuario
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Identificador exclusivo del usuario")
    private Long codigo;


    /**
     * correo electronico identificador del usuario
     */
    @NotNull(message = "email can not null")
    @ApiModelProperty("correo electronico identificador del usuario")
    private String email;


    /**
     * contrasena para acceder al servicio
     */
    @NotNull(message = "contrasena can not null")
    @ApiModelProperty("contrasena para acceder al servicio")
    private String contrasena;

}
