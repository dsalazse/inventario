package co.com.cipres.inventario.controller.reports;

import co.com.cipres.inventario.entity.Grupodato;
import co.com.cipres.inventario.service.reports.ReporteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "Entidad para presentar reportes")
@Validated
@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    /*
    * Retorna todos los datos de la fusion de las tablas grupo
    *                   datos y grupodatos
    * */
    @GetMapping(value = "/queryAllGrupoDato")
    @ApiOperation("Retrieve by query grupo, dato and grupodato in one single entity")
    public List<Grupodato> queryAllGrupoDatoReports(){
        return reporteService.queryAllGrupoDatoReport();
    }
}
