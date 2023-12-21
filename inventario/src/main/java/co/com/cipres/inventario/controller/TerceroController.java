package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.TerceroDTO;
import co.com.cipres.inventario.service.TerceroService;
import co.com.cipres.inventario.vo.TerceroQueryVO;
import co.com.cipres.inventario.vo.TerceroUpdateVO;
import co.com.cipres.inventario.vo.TerceroVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Terceros participan en alguna transaccion")
@Validated
@RestController
@RequestMapping("/tercero")
public class TerceroController {

    private TerceroService terceroService;

    @Autowired
    public TerceroController(TerceroService terceroService) {
        this.terceroService = terceroService;
    }

    @PostMapping
    @ApiOperation("Save Terceros participan en alguna transaccion")
    public String save(@Valid @RequestBody TerceroVO vO) {
        return terceroService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Terceros participan en alguna transaccion")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        terceroService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Terceros participan en alguna transaccion")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TerceroUpdateVO vO) {
        terceroService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Terceros participan en alguna transaccion")
    public TerceroDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return terceroService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Terceros participan en alguna transaccion")
    public Page<TerceroDTO> query(@Valid TerceroQueryVO vO) {
        return terceroService.query(vO);
    }
}
