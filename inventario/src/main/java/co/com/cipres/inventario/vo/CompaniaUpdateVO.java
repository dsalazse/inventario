package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel("Update Define una compania nombre comercial")
@EqualsAndHashCode(callSuper = false)
public class CompaniaUpdateVO extends CompaniaVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
