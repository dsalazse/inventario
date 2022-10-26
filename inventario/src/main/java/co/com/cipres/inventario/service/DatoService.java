package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.DatoDTO;
import co.com.cipres.inventario.entity.Dato;
import co.com.cipres.inventario.repository.DatoRepository;
import co.com.cipres.inventario.vo.DatoQueryVO;
import co.com.cipres.inventario.vo.DatoUpdateVO;
import co.com.cipres.inventario.vo.DatoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DatoService {

    @Autowired
    private DatoRepository datoRepository;

    public Long save(DatoVO vO) {
        Dato bean = new Dato();
        BeanUtils.copyProperties(vO, bean);
        bean = datoRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        datoRepository.deleteById(id);
    }

    public void update(Long id, DatoUpdateVO vO) {
        Dato bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        datoRepository.save(bean);
    }

    public DatoDTO getById(Long id) {
        Dato original = requireOne(id);
        return toDTO(original);
    }

    public Page<DatoDTO> query(DatoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DatoDTO toDTO(Dato original) {
        DatoDTO bean = new DatoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Dato requireOne(Long id) {
        return datoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
