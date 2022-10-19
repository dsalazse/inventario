package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Informacion de la operacion o del tipo de movimiento")
@EqualsAndHashCode(callSuper = false)
public class TipomovimientoUpdateVO extends TipomovimientoVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
