package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.TerceroDTO;
import co.com.cipres.inventario.entity.Tercero;
import co.com.cipres.inventario.repository.TerceroRepository;
import co.com.cipres.inventario.vo.TerceroQueryVO;
import co.com.cipres.inventario.vo.TerceroUpdateVO;
import co.com.cipres.inventario.vo.TerceroVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TerceroService {


    private TerceroRepository terceroRepository;

    @Autowired
    public TerceroService(TerceroRepository terceroRepository) {
        this.terceroRepository = terceroRepository;
    }

    public Long save(TerceroVO vO) {
        Tercero bean = new Tercero();
        BeanUtils.copyProperties(vO, bean);
        bean = terceroRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        terceroRepository.deleteById(id);
    }

    public void update(Long id, TerceroUpdateVO vO) {
        Tercero bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        terceroRepository.save(bean);
    }

    public TerceroDTO getById(Long id) {
        Tercero original = requireOne(id);
        return toDTO(original);
    }

    public Page<TerceroDTO> query(TerceroQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TerceroDTO toDTO(Tercero original) {
        TerceroDTO bean = new TerceroDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Tercero requireOne(Long id) {
        return terceroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
