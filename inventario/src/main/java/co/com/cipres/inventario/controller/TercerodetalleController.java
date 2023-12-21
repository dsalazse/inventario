package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.TercerodetalleDTO;
import co.com.cipres.inventario.service.TercerodetalleService;
import co.com.cipres.inventario.vo.TercerodetalleQueryVO;
import co.com.cipres.inventario.vo.TercerodetalleUpdateVO;
import co.com.cipres.inventario.vo.TercerodetalleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Terceros informacion detallada")
@Validated
@RestController
@RequestMapping("/tercerodetalle")
public class TercerodetalleController {

    private TercerodetalleService tercerodetalleService;

    @Autowired
    public TercerodetalleController(TercerodetalleService tercerodetalleService) {
        this.tercerodetalleService = tercerodetalleService;
    }

    @PostMapping
    @ApiOperation("Save Terceros informacion detallada")
    public String save(@Valid @RequestBody TercerodetalleVO vO) {
        return tercerodetalleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Terceros informacion detallada")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tercerodetalleService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Terceros informacion detallada")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TercerodetalleUpdateVO vO) {
        tercerodetalleService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Terceros informacion detallada")
    public TercerodetalleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tercerodetalleService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Terceros informacion detallada")
    public Page<TercerodetalleDTO> query(@Valid TercerodetalleQueryVO vO) {
        return tercerodetalleService.query(vO);
    }
}
