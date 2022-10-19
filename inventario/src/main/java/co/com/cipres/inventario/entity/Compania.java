package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Define una compania nombre comercial
 */
@Data
@Entity
@Table(name = "compania")
@ApiModel("Define una compania nombre comercial")
public class Compania implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identificador de la compania
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @ApiModelProperty("identificador de la compania")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    /**
     * Nombre de la compania
     */
    @Column(name = "nombre", nullable = false)
    @ApiModelProperty("Nombre de la compania")
    private String nombre;

    /**
     * Referencia jerarquica de la compania
     */
    @Column(name = "referencia")
    @ApiModelProperty("Referencia jerarquica de la compania")
    private Long referencia;

    /**
     * Indica si la compania se encuentra activa
     */
    @Column(name = "activo")
    @ApiModelProperty("Indica si la compania se encuentra activa")
    private Boolean activo;

    /**
     * Usuario para auditoria
     */
    @ApiModelProperty("Usuario para auditoria")
    @Column(name = "usuarioaud", nullable = false)
    private Long usuarioaud;

    /**
     * Fecha y hora para auditoria
     */
    @Column(name = "fechahoraud", nullable = false)
    @ApiModelProperty("Fecha y hora para auditoria")
    private Date fechahoraud;

}
