package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Terceros informacion detallada")
@EqualsAndHashCode(callSuper = false)
public class TercerodetalleUpdateVO extends TercerodetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
