package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad de rompimiento entre grupo y dato
 */
@Data
@Entity
@Table(name = "grupodato", schema = "inventario")
@ApiModel("Entidad de rompimiento entre grupo y dato")
public class Grupodato implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria de grupodato
     */
    @Id
    @Column(name = "id", nullable = false)
    @ApiModelProperty("Llave primaria de grupodato")
    private Long id;

    /**
     * Relacion foranea con grupo
     */
    /*
    @Column(name = "grupofk", nullable = false)
    @ApiModelProperty("Relacion foranea con grupo")
    private Long grupofk;

    /**
     * Relacion foranea con dato
     */
    /*
    @Column(name = "datofk", nullable = false)
    @ApiModelProperty("Relacion foranea con dato")
    private Long datofk;
    */

    @ManyToOne
    @JoinColumn(name="grupofk")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name="datofk")
    private Dato dato;
}