package co.com.cipres.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * Tabla de transacciones detallada
 */
@Data
@Entity
@Table(name = "transaccion", schema = "inventario")
@ApiModel("Tabla de transacciones detallada")
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Llave primaria unico de la transaccion
     */
    @Id
    @Column(name = "codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Llave primaria unico de la transaccion")
    private Long codigo;

    /**
     * Articulo involucrado en la transaccion
     */
    @Column(name = "articulo", nullable = false)
    @ApiModelProperty("Articulo involucrado en la transaccion")
    private Long articulo;

    /**
     * Bodega donde se realiza la transaccion
     */
    @Column(name = "bodega", nullable = false)
    @ApiModelProperty("Bodega donde se realiza la transaccion")
    private Long bodega;

    /**
     * Centro de costo donde se realiza la transaccion
     */
    @Column(name = "centrocosto", nullable = false)
    @ApiModelProperty("Centro de costo donde se realiza la transaccion")
    private Long centrocosto;

    /**
     * Tercero con el que se realiza la transaccion
     */
    @Column(name = "tercero", nullable = false)
    @ApiModelProperty("Tercero con el que se realiza la transaccion")
    private Long tercero;

    /**
     * Operacion que se realiza en la transaccion
     */
    @Column(name = "tipomovimiento", nullable = false)
    @ApiModelProperty("Operacion que se realiza en la transaccion")
    private Integer tipomovimiento;

    /**
     * cantidad que se involucra en la transaccion
     */
    @Column(name = "cantidad", nullable = false)
    @ApiModelProperty("cantidad que se involucra en la transaccion")
    private Long cantidad;

    /**
     * Valor que se involucra en la transaccion
     */
    @Column(name = "valor")
    @ApiModelProperty("Valor que se involucra en la transaccion")
    private BigDecimal valor;

    /**
     * compania que se involucra en la transaccion
     */
    @Column(name = "compania", nullable = false)
    @ApiModelProperty("compania que se involucra en la transaccion")
    private Long compania;

    /**
     * Usuario que realiza la transaccion
     */
    @Column(name = "usuarioaud", nullable = false)
    @ApiModelProperty("Usuario que realiza la transaccion")
    private Long usuarioaud;

    /**
     * Fecha que realiza la transaccion
     */
    @Column(name = "fechahoraud", nullable = false)
    @ApiModelProperty("Fecha que realiza la transaccion")
    private Date fechahoraud;

    /**
     * Fecha que realiza la transaccion primera vez
     */
    @Column(name = "fecha", nullable = false)
    @ApiModelProperty("Fecha que realiza la transaccion primera vez")
    private Date fecha;

    /**
     * Hora que realiza la transaccion primera vez
     */
    @Column(name = "hora", nullable = false)
    @ApiModelProperty("Hora que realiza la transaccion primera vez")
    private Time hora;

    /**
     * Periodo anual en que realiza la transaccion
     */
    @Column(name = "vigencia", nullable = false)
    @ApiModelProperty("Periodo anual en que realiza la transaccion")
    private Integer vigencia;

}
