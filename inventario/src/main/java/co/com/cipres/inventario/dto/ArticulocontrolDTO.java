package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("$table.tableComment")
public class ArticulocontrolDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long codigo;

    private Long articulo;

    private Long maximo;

    private Long minimo;

}
