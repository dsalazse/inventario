package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.UsuarioDTO;
import co.com.cipres.inventario.service.UsuarioService;
import co.com.cipres.inventario.vo.UsuarioQueryVO;
import co.com.cipres.inventario.vo.UsuarioUpdateVO;
import co.com.cipres.inventario.vo.UsuarioVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Entidad para guardar usuarios autorizados al servicio")
@Validated
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation("Save Entidad para guardar usuarios autorizados al servicio")
    public String save(@Valid @RequestBody UsuarioVO vO) {
        return usuarioService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Entidad para guardar usuarios autorizados al servicio")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Entidad para guardar usuarios autorizados al servicio")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UsuarioUpdateVO vO) {
        usuarioService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Entidad para guardar usuarios autorizados al servicio")
    public UsuarioDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Entidad para guardar usuarios autorizados al servicio")
    public Page<UsuarioDTO> query(@Valid UsuarioQueryVO vO) {
        return usuarioService.query(vO);
    }
}
