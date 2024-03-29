package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.GrupoDTO;
import co.com.cipres.inventario.service.GrupoService;
import co.com.cipres.inventario.vo.GrupoUpdateVO;
import co.com.cipres.inventario.vo.GrupoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "Entidad que agrupa informacion")
@Validated
@RestController
@RequestMapping("/grupo")
public class GrupoController {

    private GrupoService grupoService;


    @Autowired
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @PostMapping
    @ApiOperation("Save Entidad que agrupa informacion")
    public String save(@Valid @RequestBody GrupoVO vO) {
        return grupoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Entidad que agrupa informacion")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        grupoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Entidad que agrupa informacion")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody GrupoUpdateVO vO) {
        grupoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Entidad que agrupa informacion")
    public GrupoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return grupoService.getById(id);
    }



    @GetMapping
    @ApiOperation("Retrieve by query Entidad que contiene un grupo")
    public List<GrupoDTO> query(){
        return grupoService.query();
    }
}
