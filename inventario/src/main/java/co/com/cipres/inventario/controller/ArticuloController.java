package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.ArticuloDTO;
import co.com.cipres.inventario.service.ArticuloService;
import co.com.cipres.inventario.vo.ArticuloQueryVO;
import co.com.cipres.inventario.vo.ArticuloUpdateVO;
import co.com.cipres.inventario.vo.ArticuloVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Inventario de servicios articulos")
@Validated
@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    private ArticuloService articuloService;
    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @PostMapping
    @ApiOperation("Save Inventario de servicios articulos")
    public String save(@Valid @RequestBody ArticuloVO vO) {
        return articuloService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Inventario de servicios articulos")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        articuloService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Inventario de servicios articulos")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ArticuloUpdateVO vO) {
        articuloService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Inventario de servicios articulos")
    public ArticuloDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return articuloService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Inventario de servicios articulos")
    public Page<ArticuloDTO> query(@Valid ArticuloQueryVO vO) {
        return articuloService.query(vO);
    }
}
