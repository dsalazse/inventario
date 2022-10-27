package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.GrupodatoDTO;
import co.com.cipres.inventario.service.GrupodatoService;
import co.com.cipres.inventario.vo.GrupodatoQueryVO;
import co.com.cipres.inventario.vo.GrupodatoUpdateVO;
import co.com.cipres.inventario.vo.GrupodatoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "Entidad de rompimiento entre grupo y dato")
@Validated
@RestController
@RequestMapping("/grupodato")
public class GrupodatoController {

    @Autowired
    private GrupodatoService grupodatoService;

    @PostMapping
    @ApiOperation("Save Entidad de rompimiento entre grupo y dato")
    public String save(@Valid @RequestBody GrupodatoVO vO) {
        return grupodatoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Entidad de rompimiento entre grupo y dato")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        grupodatoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Entidad de rompimiento entre grupo y dato")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody GrupodatoUpdateVO vO) {
        grupodatoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Entidad de rompimiento entre grupo y dato")
    public GrupodatoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return grupodatoService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Entidad de rompimiento entre grupo y dato")
    public List<GrupodatoDTO> query(@Valid GrupodatoQueryVO vO) {
        return grupodatoService.query();
    }
}
