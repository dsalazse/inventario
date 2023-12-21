package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.CentrocostoDTO;
import co.com.cipres.inventario.service.CentrocostoService;
import co.com.cipres.inventario.vo.CentrocostoUpdateVO;
import co.com.cipres.inventario.vo.CentrocostoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "Informacion del centro de costo")
@Validated
@RestController
@RequestMapping("/centrocosto")
public class CentrocostoController {

    private CentrocostoService centrocostoService;
    @Autowired
    public CentrocostoController(CentrocostoService centrocostoService) {
        this.centrocostoService = centrocostoService;
    }

    @PostMapping
    @ApiOperation("Save Informacion del centro de costo")
    public String save(@Valid @RequestBody CentrocostoVO vO) {
        return centrocostoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Informacion del centro de costo")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        centrocostoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Informacion del centro de costo")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CentrocostoUpdateVO vO) {
        centrocostoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Informacion del centro de costo")
    public CentrocostoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return centrocostoService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Informacion del centro de costo")
    public List<CentrocostoDTO> query() {
        return centrocostoService.query();
    }
}
