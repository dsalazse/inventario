package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Entidad que contiene un dato")
@EqualsAndHashCode(callSuper = false)
public class DatoUpdateVO extends DatoVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
