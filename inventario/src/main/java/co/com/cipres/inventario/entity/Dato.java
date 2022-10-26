package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que contiene un dato
 */
@Data
@Entity
@Table(name = "dato", schema = "inventario")
@ApiModel("Entidad que contiene un dato")
public class Dato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @ApiModelProperty("Llave primaria del dato")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false)
    @ApiModelProperty("Nombre del dato")
    private String descripcion;

    /**
     * Compañia a la que pertenece el dato
     */
    @Column(name = "compania")
    @ApiModelProperty("Compañia a la que pertenece el dato")
    private Long compania;

}
