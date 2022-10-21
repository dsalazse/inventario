package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.BodegaDTO;
import co.com.cipres.inventario.service.BodegaService;
import co.com.cipres.inventario.vo.BodegaQueryVO;
import co.com.cipres.inventario.vo.BodegaUpdateVO;
import co.com.cipres.inventario.vo.BodegaVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "Informacion de la bodega(caja)")
@Validated
@RestController
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private BodegaService bodegaService;

    @PostMapping
    @ApiOperation("Save Informacion de la bodega(caja)")
    public String save(@Valid @RequestBody BodegaVO vO) {
        return bodegaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Informacion de la bodega(caja)")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        bodegaService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Informacion de la bodega(caja)")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody BodegaUpdateVO vO) {
        bodegaService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Informacion de la bodega(caja)")
    public BodegaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return bodegaService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Informacion de la bodega(caja)")
    public List<BodegaDTO> query() {
        return bodegaService.query();
    }
}
