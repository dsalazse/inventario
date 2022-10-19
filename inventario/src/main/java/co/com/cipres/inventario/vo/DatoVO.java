package co.com.cipres.inventario.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Save Entidad que contiene un dato")
public class DatoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "descripcion can not null")
    private String descripcion;

}