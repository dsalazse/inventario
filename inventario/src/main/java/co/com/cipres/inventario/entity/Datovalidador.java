package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que expresiones regulares para validar dato
 */
@Data
@Entity
@Table(name = "datovalidador", schema = "inventario")
@ApiModel("Entidad que expresiones regulares para validar dato")
public class Datovalidador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Llave foranea de dato
     */
    @Column(name = "datofk", nullable = false)
    @ApiModelProperty("Llave foranea de dato")
    private Long datofk;

    /**
     * Expresion regular para evaluar un dato
     */
    @Column(name = "validar", nullable = false)
    @ApiModelProperty("Expresion regular para evaluar un dato")
    private String validar;

}
