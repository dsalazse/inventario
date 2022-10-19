package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Inventario de servicios articulos")
@EqualsAndHashCode(callSuper = false)
public class ArticuloUpdateVO extends ArticuloVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
