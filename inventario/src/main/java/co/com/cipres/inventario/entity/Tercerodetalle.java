package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Terceros informacion detallada
 */
@Data
@Entity
@Table(name = "tercerodetalle", schema = "inventario")
@ApiModel("Terceros informacion detallada")
public class Tercerodetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria unico de tercero detalle
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Llave primaria unico de tercero detalle")
    private Long codigo;

    /**
     * Relacion con la tabla tercero
     */
    @Column(name = "tercero", nullable = false)
    @ApiModelProperty("Relacion con la tabla tercero")
    private Long tercero;

    /**
     * Relacion con la tabla grupodato
     */
    @Column(name = "caracteristica", nullable = false)
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Long caracteristica;

    /**
     * Informacion sobre la caracteristica
     */
    @Column(name = "valor", nullable = false)
    @ApiModelProperty("Informacion sobre la caracteristica")
    private String valor;

}
