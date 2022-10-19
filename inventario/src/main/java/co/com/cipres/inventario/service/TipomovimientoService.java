package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.TipomovimientoDTO;
import co.com.cipres.inventario.entity.Tipomovimiento;
import co.com.cipres.inventario.repository.TipomovimientoRepository;
import co.com.cipres.inventario.vo.TipomovimientoQueryVO;
import co.com.cipres.inventario.vo.TipomovimientoUpdateVO;
import co.com.cipres.inventario.vo.TipomovimientoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TipomovimientoService {

    @Autowired
    private TipomovimientoRepository tipomovimientoRepository;

    public Long save(TipomovimientoVO vO) {
        Tipomovimiento bean = new Tipomovimiento();
        BeanUtils.copyProperties(vO, bean);
        bean = tipomovimientoRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        tipomovimientoRepository.deleteById(id);
    }

    public void update(Long id, TipomovimientoUpdateVO vO) {
        Tipomovimiento bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        tipomovimientoRepository.save(bean);
    }

    public TipomovimientoDTO getById(Long id) {
        Tipomovimiento original = requireOne(id);
        return toDTO(original);
    }

    public Page<TipomovimientoDTO> query(TipomovimientoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TipomovimientoDTO toDTO(Tipomovimiento original) {
        TipomovimientoDTO bean = new TipomovimientoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Tipomovimiento requireOne(Long id) {
        return tipomovimientoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
