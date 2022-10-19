package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.TercerodetalleDTO;
import co.com.cipres.inventario.entity.Tercerodetalle;
import co.com.cipres.inventario.repository.TercerodetalleRepository;
import co.com.cipres.inventario.vo.TercerodetalleQueryVO;
import co.com.cipres.inventario.vo.TercerodetalleUpdateVO;
import co.com.cipres.inventario.vo.TercerodetalleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TercerodetalleService {

    @Autowired
    private TercerodetalleRepository tercerodetalleRepository;

    public Long save(TercerodetalleVO vO) {
        Tercerodetalle bean = new Tercerodetalle();
        BeanUtils.copyProperties(vO, bean);
        bean = tercerodetalleRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        tercerodetalleRepository.deleteById(id);
    }

    public void update(Long id, TercerodetalleUpdateVO vO) {
        Tercerodetalle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        tercerodetalleRepository.save(bean);
    }

    public TercerodetalleDTO getById(Long id) {
        Tercerodetalle original = requireOne(id);
        return toDTO(original);
    }

    public Page<TercerodetalleDTO> query(TercerodetalleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TercerodetalleDTO toDTO(Tercerodetalle original) {
        TercerodetalleDTO bean = new TercerodetalleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Tercerodetalle requireOne(Long id) {
        return tercerodetalleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
