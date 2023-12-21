package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.ArticulodetalleDTO;
import co.com.cipres.inventario.service.ArticulodetalleService;
import co.com.cipres.inventario.vo.ArticulodetalleQueryVO;
import co.com.cipres.inventario.vo.ArticulodetalleUpdateVO;
import co.com.cipres.inventario.vo.ArticulodetalleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Inventario de servicios articulos el detalle")
@Validated
@RestController
@RequestMapping("/articulodetalle")
public class ArticulodetalleController {
    private ArticulodetalleService articulodetalleService;

    @Autowired
    public ArticulodetalleController(ArticulodetalleService articulodetalleService) {
        this.articulodetalleService = articulodetalleService;
    }

    @PostMapping
    @ApiOperation("Save Inventario de servicios articulos el detalle")
    public String save(@Valid @RequestBody ArticulodetalleVO vO) {
        return articulodetalleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Inventario de servicios articulos el detalle")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        articulodetalleService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Inventario de servicios articulos el detalle")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ArticulodetalleUpdateVO vO) {
        articulodetalleService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Inventario de servicios articulos el detalle")
    public ArticulodetalleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return articulodetalleService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Inventario de servicios articulos el detalle")
    public Page<ArticulodetalleDTO> query(@Valid ArticulodetalleQueryVO vO) {
        return articulodetalleService.query(vO);
    }
}
