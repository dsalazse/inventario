package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.DatoDTO;
import co.com.cipres.inventario.service.DatoService;
import co.com.cipres.inventario.vo.DatoQueryVO;
import co.com.cipres.inventario.vo.DatoUpdateVO;
import co.com.cipres.inventario.vo.DatoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "Entidad que contiene un dato")
@Validated
@RestController
@RequestMapping("/dato")
public class DatoController {

    @Autowired
    private DatoService datoService;

    @PostMapping
    @ApiOperation("Save Entidad que contiene un dato")
    public String save(@Valid @RequestBody DatoVO vO) {
        return datoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Entidad que contiene un dato")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        datoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Entidad que contiene un dato")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DatoUpdateVO vO) {
        datoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Entidad que contiene un dato")
    public DatoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return datoService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Entidad que contiene un dato")
    public List<DatoDTO> query() {
        return datoService.query();
    }
}
