package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
@ApiModel("Tabla de transacciones detallada")
public class TransaccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria unico de la transaccion
     */
    @ApiModelProperty("Llave primaria unico de la transaccion")
    private Long codigo;


    /**
     * Articulo involucrado en la transaccion
     */
    @ApiModelProperty("Articulo involucrado en la transaccion")
    private Long articulo;


    /**
     * Bodega donde se realiza la transaccion
     */
    @ApiModelProperty("Bodega donde se realiza la transaccion")
    private Long bodega;


    /**
     * Centro de costo donde se realiza la transaccion
     */
    @ApiModelProperty("Centro de costo donde se realiza la transaccion")
    private Long centrocosto;


    /**
     * Tercero con el que se realiza la transaccion
     */
    @ApiModelProperty("Tercero con el que se realiza la transaccion")
    private Long tercero;


    /**
     * Operacion que se realiza en la transaccion
     */
    @ApiModelProperty("Operacion que se realiza en la transaccion")
    private Integer tipomovimiento;


    /**
     * cantidad que se involucra en la transaccion
     */
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
    @ApiModelProperty("compania que se involucra en la transaccion")
    private Long compania;


    /**
     * Usuario que realiza la transaccion
     */
    @ApiModelProperty("Usuario que realiza la transaccion")
    private Long usuarioaud;


    /**
     * Fecha que realiza la transaccion
     */
    @ApiModelProperty("Fecha que realiza la transaccion")
    private Date fechahoraud;


    /**
     * Fecha que realiza la transaccion primera vez
     */
    @ApiModelProperty("Fecha que realiza la transaccion primera vez")
    private java.sql.Date fecha;


    /**
     * Hora que realiza la transaccion primera vez
     */
    @ApiModelProperty("Hora que realiza la transaccion primera vez")
    private Time hora;


    /**
     * Periodo anual en que realiza la transaccion
     */
    @ApiModelProperty("Periodo anual en que realiza la transaccion")
    private Integer vigencia;

}
