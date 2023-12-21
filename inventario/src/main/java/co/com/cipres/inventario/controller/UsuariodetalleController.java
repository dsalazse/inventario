package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.UsuariodetalleDTO;
import co.com.cipres.inventario.service.UsuariodetalleService;
import co.com.cipres.inventario.vo.UsuariodetalleQueryVO;
import co.com.cipres.inventario.vo.UsuariodetalleUpdateVO;
import co.com.cipres.inventario.vo.UsuariodetalleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Entidad para guardar detalle de usuarios autorizados al servicio")
@Validated
@RestController
@RequestMapping("/usuariodetalle")
public class UsuariodetalleController {
    private UsuariodetalleService usuariodetalleService;

    @Autowired
    public UsuariodetalleController(UsuariodetalleService usuariodetalleService) {
        this.usuariodetalleService = usuariodetalleService;
    }

    @PostMapping
    @ApiOperation("Save Entidad para guardar detalle de usuarios autorizados al servicio")
    public String save(@Valid @RequestBody UsuariodetalleVO vO) {
        return usuariodetalleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Entidad para guardar detalle de usuarios autorizados al servicio")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        usuariodetalleService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Entidad para guardar detalle de usuarios autorizados al servicio")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UsuariodetalleUpdateVO vO) {
        usuariodetalleService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Entidad para guardar detalle de usuarios autorizados al servicio")
    public UsuariodetalleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return usuariodetalleService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Entidad para guardar detalle de usuarios autorizados al servicio")
    public Page<UsuariodetalleDTO> query(@Valid UsuariodetalleQueryVO vO) {
        return usuariodetalleService.query(vO);
    }
}
