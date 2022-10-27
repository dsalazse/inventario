package co.com.cipres.inventario.service.reports;

import co.com.cipres.inventario.dto.reports.GrupodatoReportsDTO;
import co.com.cipres.inventario.repository.reports.ReporteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReporteService {

    @Autowired
    ReporteEntity reporteEntity;

    /*
    *  proposito retornar la informacion completa de todos los datos
    *            de las tablas: grupo, datos y grupodatos
    * */
    public List<GrupodatoReportsDTO> queryAllGrupoDatoReport(){
        return  reporteEntity.queryAllGrupoDatoReport();
    }
}
