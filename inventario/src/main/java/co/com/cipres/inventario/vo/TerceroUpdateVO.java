package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Terceros participan en alguna transaccion")
@EqualsAndHashCode(callSuper = false)
public class TerceroUpdateVO extends TerceroVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
