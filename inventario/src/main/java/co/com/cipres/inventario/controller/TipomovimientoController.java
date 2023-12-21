package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.TipomovimientoDTO;
import co.com.cipres.inventario.service.TipomovimientoService;
import co.com.cipres.inventario.vo.TipomovimientoQueryVO;
import co.com.cipres.inventario.vo.TipomovimientoUpdateVO;
import co.com.cipres.inventario.vo.TipomovimientoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Informacion de la operacion o del tipo de movimiento")
@Validated
@RestController
@RequestMapping("/tipomovimiento")
public class TipomovimientoController {

    private TipomovimientoService tipomovimientoService;

    @Autowired
    public TipomovimientoController(TipomovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    @PostMapping
    @ApiOperation("Save Informacion de la operacion o del tipo de movimiento")
    public String save(@Valid @RequestBody TipomovimientoVO vO) {
        return tipomovimientoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Informacion de la operacion o del tipo de movimiento")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tipomovimientoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Informacion de la operacion o del tipo de movimiento")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TipomovimientoUpdateVO vO) {
        tipomovimientoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Informacion de la operacion o del tipo de movimiento")
    public TipomovimientoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tipomovimientoService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Informacion de la operacion o del tipo de movimiento")
    public Page<TipomovimientoDTO> query(@Valid TipomovimientoQueryVO vO) {
        return tipomovimientoService.query(vO);
    }
}
