package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Informacion del centro de costo")
@EqualsAndHashCode(callSuper = false)
public class CentrocostoUpdateVO extends CentrocostoVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
