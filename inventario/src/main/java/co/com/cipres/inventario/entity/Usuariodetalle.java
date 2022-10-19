package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad para guardar detalle de usuarios autorizados al servicio
 */
@Data
@Entity
@Table(name = "usuariodetalle", schema = "inventario")
@ApiModel("Entidad para guardar detalle de usuarios autorizados al servicio")
public class Usuariodetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador exclusivo del detalle del usuario
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Identificador exclusivo del detalle del usuario")
    private Long codigo;

    /**
     * Llave foranea a tabla usuario
     */
    @Column(name = "usuario", nullable = false)
    @ApiModelProperty("Llave foranea a tabla usuario")
    private Long usuario;

    /**
     * Nombre(s) del usuario
     */
    @Column(name = "nombre")
    @ApiModelProperty("Nombre(s) del usuario")
    private String nombre;

    /**
     * Apellidos(s) del usuario
     */
    @Column(name = "apellido")
    @ApiModelProperty("Apellidos(s) del usuario")
    private String apellido;

    /**
     * enlace a la tabla compania
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("enlace a la tabla compania")
    private Long compania;

}
