package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Entidad para guardar usuarios autorizados al servicio")
@EqualsAndHashCode(callSuper = false)
public class UsuarioUpdateVO extends UsuarioVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
