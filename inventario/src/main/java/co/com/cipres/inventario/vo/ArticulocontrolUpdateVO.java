package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update $table.tableComment")
@EqualsAndHashCode(callSuper = false)
public class ArticulocontrolUpdateVO extends ArticulocontrolVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
