package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Tabla de transacciones detallada")
public class TransaccionVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * Llave primaria unico de la transaccion
     */
    @NotNull(message = "codigo can not null")
    @ApiModelProperty("Llave primaria unico de la transaccion")
    private Long codigo;


    /**
     * Articulo involucrado en la transaccion
     */
    @NotNull(message = "articulo can not null")
    @ApiModelProperty("Articulo involucrado en la transaccion")
    private Long articulo;


    /**
     * Bodega donde se realiza la transaccion
     */
    @NotNull(message = "bodega can not null")
    @ApiModelProperty("Bodega donde se realiza la transaccion")
    private Long bodega;


    /**
     * Centro de costo donde se realiza la transaccion
     */
    @NotNull(message = "centrocosto can not null")
    @ApiModelProperty("Centro de costo donde se realiza la transaccion")
    private Long centrocosto;


    /**
     * Tercero con el que se realiza la transaccion
     */
    @NotNull(message = "tercero can not null")
    @ApiModelProperty("Tercero con el que se realiza la transaccion")
    private Long tercero;


    /**
     * Operacion que se realiza en la transaccion
     */
    @NotNull(message = "tipomovimiento can not null")
    @ApiModelProperty("Operacion que se realiza en la transaccion")
    private Integer tipomovimiento;


    /**
     * cantidad que se involucra en la transaccion
     */
    @NotNull(message = "cantidad can not null")
    @ApiModelProperty("cantidad que se involucra en la transaccion")
    private Long cantidad;


    /**
     * Valor que se involucra en la transaccion
     */
    @ApiModelProperty("Valor que se involucra en la transaccion")
    private BigDecimal valor;


    /**
     * compania que se involucra en la transaccion
     */
    @NotNull(message = "compania can not null")
    @ApiModelProperty("compania que se involucra en la transaccion")
    private Long compania;


    /**
     * Usuario que realiza la transaccion
     */
    @NotNull(message = "usuarioaud can not null")
    @ApiModelProperty("Usuario que realiza la transaccion")
    private Long usuarioaud;


    /**
     * Fecha que realiza la transaccion
     */
    @NotNull(message = "fechahoraud can not null")
    @ApiModelProperty("Fecha que realiza la transaccion")
    private Date fechahoraud;


    /**
     * Fecha que realiza la transaccion primera vez
     */
    @NotNull(message = "fecha can not null")
    @ApiModelProperty("Fecha que realiza la transaccion primera vez")
    private java.sql.Date fecha;


    /**
     * Hora que realiza la transaccion primera vez
     */
    @NotNull(message = "hora can not null")
    @ApiModelProperty("Hora que realiza la transaccion primera vez")
    private Time hora;


    /**
     * Periodo anual en que realiza la transaccion
     */
    @NotNull(message = "vigencia can not null")
    @ApiModelProperty("Periodo anual en que realiza la transaccion")
    private Integer vigencia;

}
