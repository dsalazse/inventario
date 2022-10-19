package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Define detalles de una compania comercial")
@EqualsAndHashCode(callSuper = false)
public class CompaniadetalleUpdateVO extends CompaniadetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
