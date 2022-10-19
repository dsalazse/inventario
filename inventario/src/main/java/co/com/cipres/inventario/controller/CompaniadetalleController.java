package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.CompaniadetalleDTO;
import co.com.cipres.inventario.service.CompaniadetalleService;
import co.com.cipres.inventario.vo.CompaniadetalleQueryVO;
import co.com.cipres.inventario.vo.CompaniadetalleUpdateVO;
import co.com.cipres.inventario.vo.CompaniadetalleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Define detalles de una compania comercial")
@Validated
@RestController
@RequestMapping("/companiadetalle")
public class CompaniadetalleController {

    @Autowired
    private CompaniadetalleService companiadetalleService;

    @PostMapping
    @ApiOperation("Save Define detalles de una compania comercial")
    public String save(@Valid @RequestBody CompaniadetalleVO vO) {
        return companiadetalleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Define detalles de una compania comercial")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        companiadetalleService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Define detalles de una compania comercial")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CompaniadetalleUpdateVO vO) {
        companiadetalleService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Define detalles de una compania comercial")
    public CompaniadetalleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return companiadetalleService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Define detalles de una compania comercial")
    public Page<CompaniadetalleDTO> query(@Valid CompaniadetalleQueryVO vO) {
        return companiadetalleService.query(vO);
    }
}
