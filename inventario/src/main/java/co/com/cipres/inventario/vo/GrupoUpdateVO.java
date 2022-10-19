package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Entidad que agrupa informacion")
@EqualsAndHashCode(callSuper = false)
public class GrupoUpdateVO extends GrupoVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
