package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Terceros participan en alguna transaccion
 */
@Data
@Entity
@Table(name = "tercero")
@ApiModel("Terceros participan en alguna transaccion")
public class Tercero implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Codigo identificador unico de un tercero
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Codigo identificador unico de un tercero")
    private Long codigo;

    /**
     * Relacion con la tabla grupodato
     */
    @Column(name = "tipodocumento", nullable = false)
    @ApiModelProperty("Relacion con la tabla grupodato")
    private Integer tipodocumento;

    /**
     * Numero de documento
     */
    @ApiModelProperty("Numero de documento")
    @Column(name = "numero", nullable = false)
    private String numero;

}
