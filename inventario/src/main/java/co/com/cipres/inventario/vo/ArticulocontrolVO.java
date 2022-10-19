package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save $table.tableComment")
public class ArticulocontrolVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "codigo can not null")
    private Long codigo;

    @NotNull(message = "articulo can not null")
    private Long articulo;

    @NotNull(message = "maximo can not null")
    private Long maximo;

    @NotNull(message = "minimo can not null")
    private Long minimo;

}
