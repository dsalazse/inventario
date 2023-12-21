package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.GrupodatoDTO;
import co.com.cipres.inventario.entity.Grupodato;
import co.com.cipres.inventario.repository.GrupodatoRepository;
import co.com.cipres.inventario.vo.GrupodatoUpdateVO;
import co.com.cipres.inventario.vo.GrupodatoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GrupodatoService {
    private GrupodatoRepository grupodatoRepository;

    @Autowired
    public GrupodatoService(GrupodatoRepository grupodatoRepository) {
        this.grupodatoRepository = grupodatoRepository;
    }

    public Long save(GrupodatoVO vO) {
        Grupodato bean = new Grupodato();
        BeanUtils.copyProperties(vO, bean);
        bean = grupodatoRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        grupodatoRepository.deleteById(id);
    }

    public void update(Long id, GrupodatoUpdateVO vO) {
        Grupodato bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        grupodatoRepository.save(bean);
    }

    public GrupodatoDTO getById(Long id) {
        Grupodato original = requireOne(id);
        return toDTO(original);
    }

    public List<GrupodatoDTO> query() { return toDtos(grupodatoRepository.findAll());  }

    private GrupodatoDTO toDTO(Grupodato original) {
        GrupodatoDTO bean = new GrupodatoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Grupodato requireOne(Long id) {
        return grupodatoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private List<GrupodatoDTO> toDtos(List<Grupodato> original){
        List<GrupodatoDTO> bean = new ArrayList<>();
        for(Grupodato source:original){
            GrupodatoDTO target = new GrupodatoDTO();
            BeanUtils.copyProperties(source,target);
            bean.add(target);
        }
        return bean;
    }
}
