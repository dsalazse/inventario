package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.ArticulocontrolDTO;
import co.com.cipres.inventario.service.ArticulocontrolService;
import co.com.cipres.inventario.vo.ArticulocontrolQueryVO;
import co.com.cipres.inventario.vo.ArticulocontrolUpdateVO;
import co.com.cipres.inventario.vo.ArticulocontrolVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/articulocontrol")
public class ArticulocontrolController {

    @Autowired
    private ArticulocontrolService articulocontrolService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ArticulocontrolVO vO) {
        return articulocontrolService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        articulocontrolService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ArticulocontrolUpdateVO vO) {
        articulocontrolService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ArticulocontrolDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return articulocontrolService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public List<ArticulocontrolDTO> query()
    {
        return articulocontrolService.query();
    }
}
