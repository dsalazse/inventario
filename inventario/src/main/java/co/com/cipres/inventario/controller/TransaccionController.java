package co.com.cipres.inventario.controller;

import co.com.cipres.inventario.dto.TransaccionDTO;
import co.com.cipres.inventario.service.TransaccionService;
import co.com.cipres.inventario.vo.TransaccionQueryVO;
import co.com.cipres.inventario.vo.TransaccionUpdateVO;
import co.com.cipres.inventario.vo.TransaccionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "Tabla de transacciones detallada")
@Validated
@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping
    @ApiOperation("Save Tabla de transacciones detallada")
    public String save(@Valid @RequestBody TransaccionVO vO) {
        return transaccionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Tabla de transacciones detallada")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        transaccionService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Tabla de transacciones detallada")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TransaccionUpdateVO vO) {
        transaccionService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID Tabla de transacciones detallada")
    public TransaccionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return transaccionService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query Tabla de transacciones detallada")
    public Page<TransaccionDTO> query(@Valid TransaccionQueryVO vO) {
        return transaccionService.query(vO);
    }
}
