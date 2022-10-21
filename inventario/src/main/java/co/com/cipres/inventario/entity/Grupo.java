package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que agrupa informacion
 */
@Data
@Entity
@Table(name = "grupo", schema = "inventario")
@ApiModel("Entidad que agrupa informacion")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria de grupo
     */
    @Id
    @Column(name = "id", nullable = false)
    @ApiModelProperty("Llave primaria de grupo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del grupo
     */
    @ApiModelProperty("Nombre del grupo")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    /**
     * Compania a la que pertenece el grupo
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("Compania a la que pertenece el grupo")
    private Long compania;

}
