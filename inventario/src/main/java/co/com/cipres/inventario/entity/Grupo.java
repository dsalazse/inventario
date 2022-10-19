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
     * Llave primaria de dato
     */
    @Id
    @Column(name = "id", nullable = false)
    @ApiModelProperty("Llave primaria de dato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del dato
     */
    @ApiModelProperty("Nombre del dato")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

}
