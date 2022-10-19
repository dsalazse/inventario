package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad para guardar usuarios autorizados al servicio
 */
@Data
@Entity
@Table(name = "usuario")
@ApiModel("Entidad para guardar usuarios autorizados al servicio")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador exclusivo del usuario
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Identificador exclusivo del usuario")
    private Long codigo;

    /**
     * correo electronico identificador del usuario
     */
    @Column(name = "email", nullable = false)
    @ApiModelProperty("correo electronico identificador del usuario")
    private String email;

    /**
     * contrasena para acceder al servicio
     */
    @Column(name = "contrasena", nullable = false)
    @ApiModelProperty("contrasena para acceder al servicio")
    private String contrasena;

}
