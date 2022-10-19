package co.com.cipres.inventario.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Entidad que contiene un dato")
public class DatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String descripcion;

}
