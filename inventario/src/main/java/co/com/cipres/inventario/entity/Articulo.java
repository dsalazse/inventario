package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Inventario de servicios articulos
 */
@Data
@Entity
@Table(name = "articulo")
@ApiModel("Inventario de servicios articulos")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria del inventario
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @ApiModelProperty("Llave primaria del inventario")
    private Long codigo;

    /**
     * Descripcion del inventario
     */
    @Column(name = "descripcion", nullable = false)
    @ApiModelProperty("Descripcion del inventario")
    private String descripcion;

    /**
     * Compania del inventario
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("Compania del inventario")
    private Long compania;

    @Column(name = "usuarioaud", nullable = false)
    private Long usuarioaud;

    @Column(name = "fechahoraud", nullable = false)
    private Date fechahoraud;

}
