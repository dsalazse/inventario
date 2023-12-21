package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.CompaniaDTO;
import co.com.cipres.inventario.service.CompaniaService;
import co.com.cipres.inventario.vo.CompaniaQueryVO;
import co.com.cipres.inventario.vo.CompaniaUpdateVO;
import co.com.cipres.inventario.vo.CompaniaVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Define una compania nombre comercial")
@Validated
@RestController
@RequestMapping("/compania")
public class CompaniaController {

    private CompaniaService companiaService;

    @Autowired
    public CompaniaController(CompaniaService companiaService) {
        this.companiaService = companiaService;
    }

    @PostMapping
    @ApiOperation("Save Define una compania nombre comercial")
    public String save(@Valid @RequestBody CompaniaVO vO) {
        return companiaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Define una compania nombre comercial")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        companiaService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Define una compania nombre comercial")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CompaniaUpdateVO vO) {
        companiaService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Define una compania nombre comercial")
    public CompaniaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return companiaService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Define una compania nombre comercial")
    public Page<CompaniaDTO> query(@Valid CompaniaQueryVO vO) {
        return companiaService.query(vO);
    }
}
