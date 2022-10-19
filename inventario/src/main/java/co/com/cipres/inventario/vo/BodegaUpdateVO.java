package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Informacion de la bodega(caja)")
@EqualsAndHashCode(callSuper = false)
public class BodegaUpdateVO extends BodegaVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
