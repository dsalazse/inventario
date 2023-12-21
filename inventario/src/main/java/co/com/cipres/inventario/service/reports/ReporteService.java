package co.com.cipres.inventario.service.reports;

import co.com.cipres.inventario.entity.Grupodato;
import co.com.cipres.inventario.repository.reports.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteEntity;

    @Autowired
    public ReporteService(ReporteRepository reporteEntity) {
        this.reporteEntity = reporteEntity;
    }

    /*
    *  proposito retornar la informacion completa de todos los datos
    *            de las tablas: grupo, datos y grupodatos
    * */
    public List<Grupodato> queryAllGrupoDatoReport(){
        return reporteEntity.queryAllGrupoDatoReport() ;
    }


    /*
     *  proposito retornar la informacion completa de todos los datos
     *            de las tablas: grupo, datos y grupodatos
     * */
    public List<Grupodato> queryAllGrupoDatoReportTipoTercero(Long id) {
        return reporteEntity.queryAllGrupoDatoReportTipoTercero(id);
    }
}
