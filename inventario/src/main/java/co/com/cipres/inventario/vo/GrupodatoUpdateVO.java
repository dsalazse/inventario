package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Entidad de rompimiento entre grupo y dato")
@EqualsAndHashCode(callSuper = false)
public class GrupodatoUpdateVO extends GrupodatoVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
