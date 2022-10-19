package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Entidad para guardar detalle de usuarios autorizados al servicio")
public class UsuariodetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Identificador exclusivo del detalle del usuario
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Identificador exclusivo del detalle del usuario")
    private Long codigo;


    /**
     * Llave foranea a tabla usuario
     */
    @NotNull(message = "usuario can not null")
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
    @NotNull(message = "compania can not null")
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;

}
