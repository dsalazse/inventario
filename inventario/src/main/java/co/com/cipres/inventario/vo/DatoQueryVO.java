package co.com.cipres.inventario.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query Entidad que contiene un dato")
public class DatoQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String descripcion;

}
