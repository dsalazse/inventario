package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Entidad para guardar detalle de usuarios autorizados al servicio")
@EqualsAndHashCode(callSuper = false)
public class UsuariodetalleUpdateVO extends UsuariodetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
