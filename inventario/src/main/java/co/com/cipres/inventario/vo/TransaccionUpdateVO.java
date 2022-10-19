package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Tabla de transacciones detallada")
@EqualsAndHashCode(callSuper = false)
public class TransaccionUpdateVO extends TransaccionVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
