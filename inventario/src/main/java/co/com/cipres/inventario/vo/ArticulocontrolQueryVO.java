package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query $table.tableComment")
public class ArticulocontrolQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long codigo;

    private Long articulo;

    private Long maximo;

    private Long minimo;

}
