package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.CentrocostoDTO;
import co.com.cipres.inventario.entity.Centrocosto;
import co.com.cipres.inventario.repository.CentrocostoRepository;
import co.com.cipres.inventario.vo.CentrocostoUpdateVO;
import co.com.cipres.inventario.vo.CentrocostoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CentrocostoService {

    private CentrocostoRepository centrocostoRepository;

    @Autowired
    public CentrocostoService(CentrocostoRepository centrocostoRepository) {
        this.centrocostoRepository = centrocostoRepository;
    }

    public Long save(CentrocostoVO vO) {
        Centrocosto bean = new Centrocosto();
        BeanUtils.copyProperties(vO, bean);
        bean = centrocostoRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        centrocostoRepository.deleteById(id);
    }

    public void update(Long id, CentrocostoUpdateVO vO) {
        Centrocosto bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        centrocostoRepository.save(bean);
    }

    public CentrocostoDTO getById(Long id) {
        Centrocosto original = requireOne(id);
        return toDTO(original);
    }

    public List<CentrocostoDTO> query() { return toDtos(queryAll());}

    private CentrocostoDTO toDTO(Centrocosto original) {
        CentrocostoDTO bean = new CentrocostoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Centrocosto requireOne(Long id) {
        return centrocostoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private List<Centrocosto> queryAll(){
        return  centrocostoRepository.findAll();
    }

    private List<CentrocostoDTO> toDtos(List<Centrocosto> original){
        List<CentrocostoDTO> bean = new ArrayList<>();
        for(Centrocosto source : original){
            CentrocostoDTO target = new CentrocostoDTO();
            BeanUtils.copyProperties(source,target);
            bean.add(target);
        }
        return bean;
    }
}
