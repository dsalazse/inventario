package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
@Data
@ApiModel("Save Define una compania nombre comercial")
public class CompaniaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * identificador de la compania
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("identificador de la compania")
    private Long codigo;


    /**
     * Nombre de la compania
     */
    @NotNull(message = "nombre can not null")
    @ApiModelProperty("Nombre de la compania")
    private String nombre;


    /**
     * Referencia jerarquica de la compania
     */
    @ApiModelProperty("Referencia jerarquica de la compania")
    private Long referencia;


    /**
     * Indica si la compania se encuentra activa
     */
    @ApiModelProperty("Indica si la compania se encuentra activa")
    private Boolean activo;


    /**
     * Usuario para auditoria
     */
    @NotNull(message = "usuarioaud can not null")
    @ApiModelProperty("Usuario para auditoria")
    private Long usuarioaud;


    /**
     * Fecha y hora para auditoria
     */
    @NotNull(message = "fechahoraud can not null")
    @ApiModelProperty("Fecha y hora para auditoria")
    private Date fechahoraud;

}
