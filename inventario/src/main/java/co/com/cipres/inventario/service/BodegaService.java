package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.BodegaDTO;
import co.com.cipres.inventario.entity.Bodega;
import co.com.cipres.inventario.repository.BodegaRepository;
import co.com.cipres.inventario.vo.BodegaQueryVO;
import co.com.cipres.inventario.vo.BodegaUpdateVO;
import co.com.cipres.inventario.vo.BodegaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BodegaService {

    @Autowired
    private BodegaRepository bodegaRepository;

    public Long save(BodegaVO vO) {
        Bodega bean = new Bodega();
        BeanUtils.copyProperties(vO, bean);
        bean = bodegaRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        bodegaRepository.deleteById(id);
    }

    public void update(Long id, BodegaUpdateVO vO) {
        Bodega bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bodegaRepository.save(bean);
    }

    public BodegaDTO getById(Long id) {
        Bodega original = requireOne(id);
        return toDTO(original);
    }

    public Page<BodegaDTO> query(BodegaQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BodegaDTO toDTO(Bodega original) {
        BodegaDTO bean = new BodegaDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Bodega requireOne(Long id) {
        return bodegaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
